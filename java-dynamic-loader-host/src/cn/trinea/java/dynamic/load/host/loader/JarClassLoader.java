package cn.trinea.java.dynamic.load.host.loader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * custom jar class loader, so common lib will be load only once
 * 
 * @author <a href="http://www.trinea.cn/" target="_blank">Trinea</a>
 * 
 */
public class JarClassLoader extends URLClassLoader {

    static String PREFIX_COMMON_CLASS = "cn.trinea.java.dynamic.load.common";
    
    public JarClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    // common lib class loader to load common class
    private static ClassLoader COMMON_LIB_LOADER;

    public static ClassLoader getCommonLibLoader() {
        if (COMMON_LIB_LOADER == null) {
            synchronized (JarClassLoader.class) {
                if (COMMON_LIB_LOADER == null) {
                    COMMON_LIB_LOADER = JarClassLoader.class.getClassLoader();
                }
            }
        }
        return COMMON_LIB_LOADER;
    }

    private boolean isLibClass(String className) {
        return (className != null && className.startsWith(PREFIX_COMMON_CLASS));
    }

    @Override
    protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        if (isLibClass(className)) {
            try {
                Class<?> clazz = JarClassLoader.getCommonLibLoader().loadClass(className);
                if (clazz != null) {
                    return clazz;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return super.loadClass(className, resolve);
    }
}
