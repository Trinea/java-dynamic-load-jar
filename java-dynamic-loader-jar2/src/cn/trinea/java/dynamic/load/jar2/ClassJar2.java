package cn.trinea.java.dynamic.load.jar2;

import cn.trinea.java.dynamic.load.common.CommonClass;

/**
 * jar2 class, incluce {@link CommonClass}
 * 
 * @author <a href="http://www.trinea.cn/" target="_blank">Trinea</a>
 * 
 */
public class ClassJar2 {

    private CommonClass commonClass;

    public ClassJar2() {
        commonClass = new CommonClass("jar2");
        System.out.println("commonClass loader in ClassJar2:" + commonClass.getClass().getClassLoader());
    }

    public String getString() {
        return commonClass.getString();
    }
}
