#!/usr/bin/env bash
set -euo pipefail
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SCRIPT_DIR"

# 1) Stubs check and generation
if [ ! -f "stubs.jar" ]; then
    if [ ! -f "gen_stubs.py" ]; then
        if [ -f "/data/data/com.termux/files/usr/tmp/gen_stubs2.py" ]; then
            cp "/data/data/com.termux/files/usr/tmp/gen_stubs2.py" "gen_stubs.py"
        fi
    fi
    if [ -f "gen_stubs.py" ]; then
        python3 gen_stubs.py
    fi
fi

# 2) Clean and create build/dist dirs
rm -rf build/classes build/stage dist
mkdir -p build/classes build/stage dist

# 3) Compile sources
javac -proc:none -nowarn -encoding UTF-8 -cp "$(cat classpath.txt)" -d build/classes @core_sources.txt

# 4) Assemble stage directory
if [ -f "libs-shaded.jar" ]; then
    unzip -q libs-shaded.jar -d build/stage
fi

if [ -d "build/classes" ]; then
    cp -r build/classes/* build/stage/
fi

if [ -d "resources" ]; then
    # Copy resources contents into build/stage root
    # Keep resources/META-INF/MANIFEST.MF if present
    MANIFEST_SRC="resources/META-INF/MANIFEST.MF"
    HAS_MANIFEST=0
    if [ -f "$MANIFEST_SRC" ]; then
        HAS_MANIFEST=1
    fi

    cp -r resources/* build/stage/

    if [ "$HAS_MANIFEST" -eq 1 ]; then
        mkdir -p build/stage/META-INF
        cp "$MANIFEST_SRC" build/stage/META-INF/MANIFEST.MF
    fi
fi

# Remove signature files if any
rm -f build/stage/META-INF/*.SF build/stage/META-INF/*.RSA build/stage/META-INF/*.DSA

# Remove stubs classes from build/stage if present (compile-time only)
rm -rf build/stage/com/Zrips \
       build/stage/de/myzelyam \
       build/stage/me/chancesd \
       build/stage/net/skinsrestorer \
       build/stage/me/ulrich/entitywizard

# 5) Create final jar
cd build/stage
if [ -f "META-INF/MANIFEST.MF" ]; then
    jar cfm ../../dist/UltimateClans-9.3.1.jar META-INF/MANIFEST.MF .
else
    jar cf ../../dist/UltimateClans-9.3.1.jar .
fi
cd "$SCRIPT_DIR"

# 6) Verify final jar
JAR_FILE="dist/UltimateClans-9.3.1.jar"
FAIL=0

if [ ! -f "$JAR_FILE" ]; then
    echo "FAIL: Jar file not created"
    exit 1
fi

# Check required entries inside jar
jar tf "$JAR_FILE" | grep -q "^plugin.yml$" || { echo "Missing plugin.yml"; FAIL=1; }
jar tf "$JAR_FILE" | grep -q "^license.yml$" || { echo "Missing license.yml"; FAIL=1; }
jar tf "$JAR_FILE" | grep -q "^me/ulrich/clans/Clans.class$" || { echo "Missing Clans.class"; FAIL=1; }
jar tf "$JAR_FILE" | grep -q "^language/.*\.yml$" || { echo "Missing language/*.yml"; FAIL=1; }
jar tf "$JAR_FILE" | grep -q "^extensions/.*\.jar$" || { echo "Missing extensions/*.jar"; FAIL=1; }

# Ensure stubs classes are NOT in the jar
if jar tf "$JAR_FILE" | grep -E '^(com/Zrips|de/myzelyam|me/chancesd|net/skinsrestorer|me/ulrich/entitywizard)/'; then
    echo "FAIL: Stubs classes found in final jar"
    FAIL=1
fi

ENTRY_COUNT=$(jar tf "$JAR_FILE" | wc -l)
FILE_SIZE=$(du -h "$JAR_FILE" | cut -f1)

echo "Entry count: $ENTRY_COUNT"
echo "Size: $FILE_SIZE"

if [ "$FAIL" -eq 1 ]; then
    echo "FAIL"
    exit 1
else
    echo "PASS"
    exit 0
fi
