package cn.trinea.java.dynamic.load.jar2;

import cn.trinea.java.dynamic.load.common.CommonClass;

public class ChildCommonClass2 extends CommonClass {

    @Override
    public String getString() {
        return s == null ? "ChildCommonClass2" : s;
    }

    public ChildCommonClass2(String s) {
        super(s);
    }

    public ChildCommonClass2() {
        super(null);
    }

}
