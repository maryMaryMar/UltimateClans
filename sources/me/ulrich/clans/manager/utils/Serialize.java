package me.ulrich.clans.manager.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Serialize.class */
public class Serialize {
    private static volatile String p6FK4h0A8L35OYgJ;
    private static String IhlfbUYekb7rjQ8KES;
    private static String BoZIeAurVzwOof2gt6T;
    private static final byte[] prGjAJ1ZgBpgnw0yhk1k = {(byte) 9, (byte) 41, (byte) 67, (byte) 22, (byte) 126, (byte) 127, (byte) 104, (byte) 165, (byte) 50, (byte) 82, (byte) 117, (byte) 146, (byte) 79, (byte) 97, (byte) 224, (byte) 132, (byte) 169, (byte) 169, (byte) 124, (byte) 105, (byte) 155, (byte) 241, (byte) 153, (byte) 129, (byte) 240, (byte) 229, (byte) 104, (byte) 80, (byte) 163, (byte) 125, (byte) 197, (byte) 28};
    private static final byte[] KnQ6F1FNiC07Rn = {(byte) 38, (byte) 105, (byte) 173, (byte) 233, (byte) 27, (byte) 81, (byte) 32, (byte) 208, (byte) 117, (byte) 211, (byte) 107, (byte) 139, (byte) 87, (byte) 75, (byte) 113, (byte) 94, (byte) 144, (byte) 70, (byte) 251, (byte) 132, (byte) 119, (byte) 236, (byte) 154, (byte) 149, (byte) 202, (byte) 91, (byte) 55, (byte) 67, (byte) 15, (byte) 250, (byte) 169, (byte) 98, (byte) 37, (byte) 176, (byte) 199, (byte) 82, (byte) 158, (byte) 174, (byte) 170, (byte) 39, (byte) 15, (byte) 93, (byte) 154, (byte) 170, (byte) 142, (byte) 140, (byte) 109, (byte) 190};

    public String toBase64(Inventory inventory) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(byteArrayOutputStream);
                try {
                    bukkitObjectOutputStream.writeInt(inventory.getSize());
                    for (int i = 0; i < inventory.getSize(); i++) {
                        bukkitObjectOutputStream.writeObject(inventory.getItem(i));
                    }
                    String strEncodeToString = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
                    bukkitObjectOutputStream.close();
                    byteArrayOutputStream.close();
                    return strEncodeToString;
                } catch (Throwable th) {
                    try {
                        bukkitObjectOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            throw new IllegalStateException(WlX99VdUkg2PWJ0s(), e);
        }
    }

    public String itemStackToBase64(ItemStack itemStack) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(byteArrayOutputStream);
                try {
                    bukkitObjectOutputStream.writeInt(1);
                    bukkitObjectOutputStream.writeObject(itemStack);
                    String strEncodeToString = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
                    bukkitObjectOutputStream.close();
                    byteArrayOutputStream.close();
                    return strEncodeToString;
                } catch (Throwable th) {
                    try {
                        bukkitObjectOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            throw new IllegalStateException(C0KbxQOSpFWjJQX(), e);
        }
    }

    public ItemStack itemStackFromBase64(String str) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getMimeDecoder().decode(str));
            try {
                BukkitObjectInputStream bukkitObjectInputStream = new BukkitObjectInputStream(byteArrayInputStream);
                try {
                    if (bukkitObjectInputStream.readInt() <= 0) {
                        bukkitObjectInputStream.close();
                        byteArrayInputStream.close();
                        return null;
                    }
                    ItemStack itemStack = (ItemStack) bukkitObjectInputStream.readObject();
                    bukkitObjectInputStream.close();
                    byteArrayInputStream.close();
                    return itemStack;
                } catch (Throwable th) {
                    try {
                        bukkitObjectInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String itemStackArrayToBase64(ItemStack[] itemStackArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(byteArrayOutputStream);
                try {
                    bukkitObjectOutputStream.writeInt(itemStackArr.length);
                    for (ItemStack itemStack : itemStackArr) {
                        bukkitObjectOutputStream.writeObject(itemStack);
                    }
                    String strEncodeToString = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
                    bukkitObjectOutputStream.close();
                    byteArrayOutputStream.close();
                    return strEncodeToString;
                } catch (Throwable th) {
                    try {
                        bukkitObjectOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            throw new IllegalStateException(PxqBmsFg2V47yGdb(), e);
        }
    }

    public ItemStack[] itemStackArrayFromBase64(String str) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getMimeDecoder().decode(str));
            try {
                BukkitObjectInputStream bukkitObjectInputStream = new BukkitObjectInputStream(byteArrayInputStream);
                try {
                    int i = bukkitObjectInputStream.readInt();
                    ItemStack[] itemStackArr = new ItemStack[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        itemStackArr[i2] = (ItemStack) bukkitObjectInputStream.readObject();
                    }
                    bukkitObjectInputStream.close();
                    byteArrayInputStream.close();
                    return itemStackArr;
                } catch (Throwable th) {
                    try {
                        bukkitObjectInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String zpb0kArrJjw4Psnbm(byte[] bArr) {
        return "";
    }

    private static String WlX99VdUkg2PWJ0s() {
        return "Failed to serialize inventory";
    }

    private static String C0KbxQOSpFWjJQX() {
        return "Failed to serialize item";
    }

    private static String PxqBmsFg2V47yGdb() {
        return "Failed to serialize item array";
    }
}
