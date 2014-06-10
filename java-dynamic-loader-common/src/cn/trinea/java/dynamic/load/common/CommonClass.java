package cn.trinea.java.dynamic.load.common;

/**
 * common class will be included both in jar1, jar2 and host
 * 
 * @author <a href="http://www.trinea.cn/" target="_blank">Trinea</a>
 * 
 */
public class CommonClass {

    protected String s;

    public CommonClass(String s) {
        this.s = s;
    }

    public String getString() {
        return s;
    }
}
