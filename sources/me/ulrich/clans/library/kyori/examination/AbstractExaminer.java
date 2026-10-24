package me.ulrich.clans.library.kyori.examination;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/AbstractExaminer.class */
public abstract class AbstractExaminer<R> implements Examiner<R> {
    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(@Nullable Object obj) {
        if (obj == null) {
            return nil();
        }
        if (obj instanceof String) {
            return examine((String) obj);
        }
        if (obj instanceof Examinable) {
            return examine((Examinable) obj);
        }
        if (obj instanceof Collection) {
            return collection((Collection) obj);
        }
        if (obj instanceof Map) {
            return map((Map) obj);
        }
        if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType.isPrimitive()) {
                if (componentType == Boolean.TYPE) {
                    return examine((boolean[]) obj);
                }
                if (componentType == Byte.TYPE) {
                    return examine((byte[]) obj);
                }
                if (componentType == Character.TYPE) {
                    return examine((char[]) obj);
                }
                if (componentType == Double.TYPE) {
                    return examine((double[]) obj);
                }
                if (componentType == Float.TYPE) {
                    return examine((float[]) obj);
                }
                if (componentType == Integer.TYPE) {
                    return examine((int[]) obj);
                }
                if (componentType == Long.TYPE) {
                    return examine((long[]) obj);
                }
                if (componentType == Short.TYPE) {
                    return examine((short[]) obj);
                }
            }
            return array((Object[]) obj);
        }
        if (obj instanceof Boolean) {
            return examine(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Character) {
            return examine(((Character) obj).charValue());
        }
        if (obj instanceof Number) {
            if (obj instanceof Byte) {
                return examine(((Byte) obj).byteValue());
            }
            if (obj instanceof Double) {
                return examine(((Double) obj).doubleValue());
            }
            if (obj instanceof Float) {
                return examine(((Float) obj).floatValue());
            }
            if (obj instanceof Integer) {
                return examine(((Integer) obj).intValue());
            }
            if (obj instanceof Long) {
                return examine(((Long) obj).longValue());
            }
            if (obj instanceof Short) {
                return examine(((Short) obj).shortValue());
            }
        } else if (obj instanceof BaseStream) {
            if (obj instanceof Stream) {
                return stream((Stream) obj);
            }
            if (obj instanceof DoubleStream) {
                return stream((DoubleStream) obj);
            }
            if (obj instanceof IntStream) {
                return stream((IntStream) obj);
            }
            if (obj instanceof LongStream) {
                return stream((LongStream) obj);
            }
        }
        return scalar(obj);
    }

    @NotNull
    private <E> R array(E[] eArr) {
        return array(eArr, Arrays.stream(eArr).map(this::examine));
    }

    @NotNull
    protected abstract <E> R array(E[] eArr, @NotNull Stream<R> stream);

    @NotNull
    private <E> R collection(@NotNull Collection<E> collection) {
        return collection(collection, collection.stream().map(this::examine));
    }

    @NotNull
    protected abstract <E> R collection(@NotNull Collection<E> collection, @NotNull Stream<R> stream);

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(@NotNull String str, @NotNull Stream<? extends ExaminableProperty> stream) {
        return examinable(str, stream.map(examinableProperty -> {
            return new AbstractMap.SimpleImmutableEntry(examinableProperty.name(), examinableProperty.examine(this));
        }));
    }

    @NotNull
    protected abstract R examinable(@NotNull String str, @NotNull Stream<Map.Entry<String, R>> stream);

    @NotNull
    private <K, V> R map(@NotNull Map<K, V> map) {
        return map(map, map.entrySet().stream().map(entry -> {
            return new AbstractMap.SimpleImmutableEntry(examine(entry.getKey()), examine(entry.getValue()));
        }));
    }

    @NotNull
    protected abstract <K, V> R map(@NotNull Map<K, V> map, @NotNull Stream<Map.Entry<R, R>> stream);

    @NotNull
    protected abstract R nil();

    @NotNull
    protected abstract R scalar(@NotNull Object obj);

    @NotNull
    protected abstract <T> R stream(@NotNull Stream<T> stream);

    @NotNull
    protected abstract R stream(@NotNull DoubleStream doubleStream);

    @NotNull
    protected abstract R stream(@NotNull IntStream intStream);

    @NotNull
    protected abstract R stream(@NotNull LongStream longStream);

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(boolean[] zArr) {
        return zArr == null ? nil() : array(zArr.length, i -> {
            return examine(zArr[i]);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(byte[] bArr) {
        return bArr == null ? nil() : array(bArr.length, i -> {
            return examine(bArr[i]);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(char[] cArr) {
        return cArr == null ? nil() : array(cArr.length, i -> {
            return examine(cArr[i]);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(double[] dArr) {
        return dArr == null ? nil() : array(dArr.length, i -> {
            return examine(dArr[i]);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(float[] fArr) {
        return fArr == null ? nil() : array(fArr.length, i -> {
            return examine(fArr[i]);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(int[] iArr) {
        return iArr == null ? nil() : array(iArr.length, i -> {
            return examine(iArr[i]);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(long[] jArr) {
        return jArr == null ? nil() : array(jArr.length, i -> {
            return examine(jArr[i]);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public R examine(short[] sArr) {
        return sArr == null ? nil() : array(sArr.length, i -> {
            return examine(sArr[i]);
        });
    }

    @NotNull
    protected abstract R array(int i, IntFunction<R> intFunction);
}
