package cn.trinea.java.dynamic.load.jar1;

import cn.trinea.java.dynamic.load.common.CommonClass;

/**
 * jar1 class, incluce {@link CommonClass}
 * 
 * @author <a href="http://www.trinea.cn/" target="_blank">Trinea</a>
 * 
 */
public class ClassJar1 {

    private CommonClass commonClass;

    public ClassJar1() {
        commonClass = new CommonClass("jar1");
        System.out.println("commonClass loader in ClassJar1:" + commonClass.getClass().getClassLoader());
    }

    public String getString() {
        return commonClass.getString();
    }
}
