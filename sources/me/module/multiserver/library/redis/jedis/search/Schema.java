package me.module.multiserver.library.redis.jedis.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Schema.class */
public class Schema {

    @Deprecated
    public final List<Field> fields = new ArrayList();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Schema$Field.class */
    public static class Field implements IParams {
        protected final FieldName fieldName;

        @Deprecated
        public final String name;

        @Deprecated
        public final FieldType type;

        @Deprecated
        public final boolean sortable;

        @Deprecated
        public final boolean noIndex;

        public Field(String str, FieldType fieldType) {
            this(str, fieldType, false, false);
        }

        public Field(String str, FieldType fieldType, boolean z) {
            this(str, fieldType, z, false);
        }

        public Field(String str, FieldType fieldType, boolean z, boolean z2) {
            this(FieldName.of(str), fieldType, z, z2);
        }

        public Field(FieldName fieldName, FieldType fieldType) {
            this(fieldName, fieldType, false, false);
        }

        public Field(FieldName fieldName, FieldType fieldType, boolean z, boolean z2) {
            this.fieldName = fieldName;
            this.name = this.fieldName.getName();
            this.type = fieldType;
            this.sortable = z;
            this.noIndex = z2;
        }

        public void as(String str) {
            this.fieldName.as(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.params.IParams
        public final void addParams(CommandArguments commandArguments) {
            this.fieldName.addParams(commandArguments);
            commandArguments.add(this.type.name());
            addTypeArgs(commandArguments);
            if (this.sortable) {
                commandArguments.add("SORTABLE");
            }
            if (this.noIndex) {
                commandArguments.add("NOINDEX");
            }
        }

        protected void addTypeArgs(CommandArguments commandArguments) {
        }

        public String toString() {
            return "Field{name='" + this.fieldName + "', type=" + this.type + ", sortable=" + this.sortable + ", noindex=" + this.noIndex + "}";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Schema$FieldType.class */
    public enum FieldType {
        TAG,
        TEXT,
        GEO,
        NUMERIC,
        VECTOR
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Schema$TagField.class */
    public static class TagField extends Field {
        private final String separator;
        private final boolean caseSensitive;

        public TagField(String str) {
            this(str, (String) null);
        }

        public TagField(String str, String str2) {
            this(str, str2, false);
        }

        public TagField(String str, boolean z) {
            this(str, (String) null, z);
        }

        public TagField(String str, String str2, boolean z) {
            this(str, str2, false, z);
        }

        public TagField(String str, boolean z, boolean z2) {
            this(str, (String) null, z, z2);
        }

        public TagField(String str, String str2, boolean z, boolean z2) {
            super(str, FieldType.TAG, z2);
            this.separator = str2;
            this.caseSensitive = z;
        }

        public TagField(FieldName fieldName, String str, boolean z) {
            this(fieldName, str, false, z);
        }

        public TagField(FieldName fieldName, String str, boolean z, boolean z2) {
            super(fieldName, FieldType.TAG, z2, false);
            this.separator = str;
            this.caseSensitive = z;
        }

        @Override // me.module.multiserver.library.redis.jedis.search.Schema.Field
        public void addTypeArgs(CommandArguments commandArguments) {
            if (this.separator != null) {
                commandArguments.add("SEPARATOR");
                commandArguments.add(this.separator);
            }
            if (this.caseSensitive) {
                commandArguments.add("CASESENSITIVE");
            }
        }

        @Override // me.module.multiserver.library.redis.jedis.search.Schema.Field
        public String toString() {
            return "TagField{name='" + this.fieldName + "', type=" + this.type + ", sortable=" + this.sortable + ", noindex=" + this.noIndex + ", separator='" + this.separator + ", caseSensitive='" + this.caseSensitive + "'}";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Schema$TextField.class */
    public static class TextField extends Field {
        private final double weight;
        private final boolean nostem;
        private final String phonetic;

        public TextField(String str) {
            this(str, 1.0d);
        }

        public TextField(FieldName fieldName) {
            this(fieldName, 1.0d, false, false, false, (String) null);
        }

        public TextField(String str, double d) {
            this(str, d, false);
        }

        public TextField(String str, double d, boolean z) {
            this(str, d, z, false);
        }

        public TextField(String str, double d, boolean z, boolean z2) {
            this(str, d, z, z2, false);
        }

        public TextField(String str, double d, boolean z, boolean z2, boolean z3) {
            this(str, d, z, z2, z3, (String) null);
        }

        public TextField(String str, double d, boolean z, boolean z2, boolean z3, String str2) {
            super(str, FieldType.TEXT, z, z3);
            this.weight = d;
            this.nostem = z2;
            this.phonetic = str2;
        }

        public TextField(FieldName fieldName, double d, boolean z, boolean z2, boolean z3, String str) {
            super(fieldName, FieldType.TEXT, z, z3);
            this.weight = d;
            this.nostem = z2;
            this.phonetic = str;
        }

        @Override // me.module.multiserver.library.redis.jedis.search.Schema.Field
        protected void addTypeArgs(CommandArguments commandArguments) {
            if (this.weight != 1.0d) {
                commandArguments.add("WEIGHT");
                commandArguments.add(Double.toString(this.weight));
            }
            if (this.nostem) {
                commandArguments.add("NOSTEM");
            }
            if (this.phonetic != null) {
                commandArguments.add("PHONETIC");
                commandArguments.add(this.phonetic);
            }
        }

        @Override // me.module.multiserver.library.redis.jedis.search.Schema.Field
        public String toString() {
            return "TextField{name='" + this.fieldName + "', type=" + this.type + ", sortable=" + this.sortable + ", noindex=" + this.noIndex + ", weight=" + this.weight + ", nostem=" + this.nostem + ", phonetic='" + this.phonetic + "'}";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Schema$VectorField.class */
    public static class VectorField extends Field {
        private final VectorAlgo algorithm;
        private final Map<String, Object> attributes;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Schema$VectorField$VectorAlgo.class */
        public enum VectorAlgo {
            FLAT,
            HNSW
        }

        public VectorField(String str, VectorAlgo vectorAlgo, Map<String, Object> map) {
            super(str, FieldType.VECTOR);
            this.algorithm = vectorAlgo;
            this.attributes = map;
        }

        @Override // me.module.multiserver.library.redis.jedis.search.Schema.Field
        public void addTypeArgs(CommandArguments commandArguments) {
            commandArguments.add(this.algorithm);
            commandArguments.add(Integer.valueOf(this.attributes.size() * 2));
            for (Map.Entry<String, Object> entry : this.attributes.entrySet()) {
                commandArguments.add(entry.getKey());
                commandArguments.add(entry.getValue());
            }
        }

        @Override // me.module.multiserver.library.redis.jedis.search.Schema.Field
        public String toString() {
            return "VectorField{name='" + this.fieldName + "', type=" + this.type + ", algorithm=" + this.algorithm + ", attributes=" + this.attributes + "}";
        }
    }

    public static Schema from(Field... fieldArr) {
        Schema schema = new Schema();
        for (Field field : fieldArr) {
            schema.addField(field);
        }
        return schema;
    }

    public Schema addTextField(String str, double d) {
        this.fields.add(new TextField(str, d));
        return this;
    }

    public Schema addSortableTextField(String str, double d) {
        this.fields.add(new TextField(str, d, true));
        return this;
    }

    public Schema addGeoField(String str) {
        this.fields.add(new Field(str, FieldType.GEO, false));
        return this;
    }

    public Schema addNumericField(String str) {
        this.fields.add(new Field(str, FieldType.NUMERIC, false));
        return this;
    }

    public Schema addSortableNumericField(String str) {
        this.fields.add(new Field(str, FieldType.NUMERIC, true));
        return this;
    }

    public Schema addTagField(String str) {
        this.fields.add(new TagField(str));
        return this;
    }

    public Schema addTagField(String str, String str2) {
        this.fields.add(new TagField(str, str2));
        return this;
    }

    public Schema addTagField(String str, boolean z) {
        this.fields.add(new TagField(str, z, false));
        return this;
    }

    public Schema addTagField(String str, String str2, boolean z) {
        this.fields.add(new TagField(str, str2, z, false));
        return this;
    }

    public Schema addSortableTagField(String str, String str2) {
        this.fields.add(new TagField(str, str2, true));
        return this;
    }

    public Schema addSortableTagField(String str, boolean z) {
        this.fields.add(new TagField(str, z, true));
        return this;
    }

    public Schema addSortableTagField(String str, String str2, boolean z) {
        this.fields.add(new TagField(str, str2, z, true));
        return this;
    }

    public Schema addVectorField(String str, VectorField.VectorAlgo vectorAlgo, Map<String, Object> map) {
        this.fields.add(new VectorField(str, vectorAlgo, map));
        return this;
    }

    public Schema addFlatVectorField(String str, Map<String, Object> map) {
        this.fields.add(new VectorField(str, VectorField.VectorAlgo.FLAT, map));
        return this;
    }

    public Schema addHNSWVectorField(String str, Map<String, Object> map) {
        this.fields.add(new VectorField(str, VectorField.VectorAlgo.HNSW, map));
        return this;
    }

    public Schema addField(Field field) {
        this.fields.add(field);
        return this;
    }

    public Schema as(String str) {
        this.fields.get(this.fields.size() - 1).as(str);
        return this;
    }

    public String toString() {
        return "Schema{fields=" + this.fields + "}";
    }
}
