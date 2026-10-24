package me.ulrich.clans.library.hikari.util;

import java.io.File;
import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javassist.ClassMap;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.LoaderClassPath;
import javassist.Modifier;
import javassist.NotFoundException;
import me.ulrich.clans.library.hikari.pool.ProxyCallableStatement;
import me.ulrich.clans.library.hikari.pool.ProxyConnection;
import me.ulrich.clans.library.hikari.pool.ProxyDatabaseMetaData;
import me.ulrich.clans.library.hikari.pool.ProxyPreparedStatement;
import me.ulrich.clans.library.hikari.pool.ProxyResultSet;
import me.ulrich.clans.library.hikari.pool.ProxyStatement;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/JavassistProxyFactory.class */
public final class JavassistProxyFactory {
    private static ClassPool classPool;
    private static String genDirectory = "target" + File.separator + "classes";

    public static void main(String... strArr) {
        classPool = new ClassPool();
        classPool.importPackage("java.sql");
        classPool.appendClassPath(new LoaderClassPath(JavassistProxyFactory.class.getClassLoader()));
        if (strArr.length > 0) {
            String str = strArr[0];
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            genDirectory = str + genDirectory;
        }
        System.out.println("Generating following classes to " + genDirectory);
        generateProxyClass(Connection.class, ProxyConnection.class.getName(), "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }");
        generateProxyClass(Statement.class, ProxyStatement.class.getName(), "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }");
        generateProxyClass(ResultSet.class, ProxyResultSet.class.getName(), "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }");
        generateProxyClass(DatabaseMetaData.class, ProxyDatabaseMetaData.class.getName(), "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }");
        generateProxyClass(PreparedStatement.class, ProxyPreparedStatement.class.getName(), "{ try { return ((cast) delegate).method($$); } catch (SQLException e) { throw checkException(e); } }");
        generateProxyClass(CallableStatement.class, ProxyCallableStatement.class.getName(), "{ try { return ((cast) delegate).method($$); } catch (SQLException e) { throw checkException(e); } }");
        modifyProxyFactory();
    }

    private static void modifyProxyFactory() {
        System.out.println("Generating method bodies for com.zaxxer.hikari.proxy.ProxyFactory");
        String name = ProxyConnection.class.getPackage().getName();
        CtClass ctClass = classPool.getCtClass("me.ulrich.clans.library.hikari.pool.ProxyFactory");
        for (CtMethod ctMethod : ctClass.getMethods()) {
            switch (ctMethod.getName()) {
                case "getProxyConnection":
                    ctMethod.setBody("{return new " + name + ".HikariProxyConnection($$);}");
                    break;
                case "getProxyStatement":
                    ctMethod.setBody("{return new " + name + ".HikariProxyStatement($$);}");
                    break;
                case "getProxyPreparedStatement":
                    ctMethod.setBody("{return new " + name + ".HikariProxyPreparedStatement($$);}");
                    break;
                case "getProxyCallableStatement":
                    ctMethod.setBody("{return new " + name + ".HikariProxyCallableStatement($$);}");
                    break;
                case "getProxyResultSet":
                    ctMethod.setBody("{return new " + name + ".HikariProxyResultSet($$);}");
                    break;
                case "getProxyDatabaseMetaData":
                    ctMethod.setBody("{return new " + name + ".HikariProxyDatabaseMetaData($$);}");
                    break;
            }
        }
        ctClass.writeFile(genDirectory);
    }

    private static <T> void generateProxyClass(Class<T> cls, String str, String str2) {
        String strReplaceAll = str.replaceAll("(.+)\\.(\\w+)", "$1.Hikari$2");
        CtClass ctClass = classPool.getCtClass(str);
        CtClass ctClassMakeClass = classPool.makeClass(strReplaceAll, ctClass);
        ctClassMakeClass.setModifiers(Modifier.setPublic(16));
        System.out.println("Generating " + strReplaceAll);
        HashSet hashSet = new HashSet();
        for (CtMethod ctMethod : ctClass.getMethods()) {
            if ((ctMethod.getModifiers() & 16) == 16) {
                hashSet.add(ctMethod.getName() + ctMethod.getSignature());
            }
        }
        HashSet hashSet2 = new HashSet();
        for (Class<?> cls2 : getAllInterfaces(cls)) {
            CtClass ctClass2 = classPool.getCtClass(cls2.getName());
            ctClassMakeClass.addInterface(ctClass2);
            for (CtMethod ctMethod2 : ctClass2.getDeclaredMethods()) {
                String str3 = ctMethod2.getName() + ctMethod2.getSignature();
                if (!hashSet.contains(str3) && !hashSet2.contains(str3)) {
                    hashSet2.add(str3);
                    CtMethod ctMethodCopy = CtNewMethod.copy(ctMethod2, ctClassMakeClass, (ClassMap) null);
                    String strReplace = str2;
                    if ((ctClass.getMethod(ctMethod2.getName(), ctMethod2.getSignature()).getModifiers() & 1024) != 1024 && !isDefaultMethod(cls2, ctMethod2)) {
                        strReplace = strReplace.replace("((cast) ", "").replace("delegate", "super").replace("super)", "super");
                    }
                    String strReplace2 = isThrowsSqlException(ctMethod2) ? strReplace.replace("cast", cls.getName()).replace("method", ctMethodCopy.getName()) : "{ return ((cast) delegate).method($$); }".replace("method", ctMethodCopy.getName()).replace("cast", cls.getName());
                    if (ctMethodCopy.getReturnType() == CtClass.voidType) {
                        strReplace2 = strReplace2.replace("return", "");
                    }
                    ctMethodCopy.setBody(strReplace2);
                    ctClassMakeClass.addMethod(ctMethodCopy);
                }
            }
        }
        ctClassMakeClass.getClassFile().setMajorVersion(52);
        ctClassMakeClass.writeFile(genDirectory);
    }

    private static boolean isThrowsSqlException(CtMethod ctMethod) {
        try {
            for (CtClass ctClass : ctMethod.getExceptionTypes()) {
                if (ctClass.getSimpleName().equals("SQLException")) {
                    return true;
                }
            }
            return false;
        } catch (NotFoundException e) {
            return false;
        }
    }

    private static boolean isDefaultMethod(Class<?> cls, CtMethod ctMethod) {
        ArrayList arrayList = new ArrayList();
        for (CtClass ctClass : ctMethod.getParameterTypes()) {
            arrayList.add(toJavaClass(ctClass));
        }
        return cls.getDeclaredMethod(ctMethod.getName(), (Class[]) arrayList.toArray(new Class[0])).toString().contains("default ");
    }

    private static Set<Class<?>> getAllInterfaces(Class<?> cls) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (cls2.getInterfaces().length > 0) {
                linkedHashSet.addAll(getAllInterfaces(cls2));
            }
            linkedHashSet.add(cls2);
        }
        if (cls.getSuperclass() != null) {
            linkedHashSet.addAll(getAllInterfaces(cls.getSuperclass()));
        }
        if (cls.isInterface()) {
            linkedHashSet.add(cls);
        }
        return linkedHashSet;
    }

    private static Class<?> toJavaClass(CtClass ctClass) {
        return ctClass.getName().endsWith("[]") ? Array.newInstance(toJavaClass(ctClass.getName().replace("[]", "")), 0).getClass() : toJavaClass(ctClass.getName());
    }

    private static Class<?> toJavaClass(String str) {
        switch (str) {
            case "int":
                return Integer.TYPE;
            case "long":
                return Long.TYPE;
            case "short":
                return Short.TYPE;
            case "byte":
                return Byte.TYPE;
            case "float":
                return Float.TYPE;
            case "double":
                return Double.TYPE;
            case "boolean":
                return Boolean.TYPE;
            case "char":
                return Character.TYPE;
            case "void":
                return Void.TYPE;
            default:
                return Class.forName(str);
        }
    }
}
