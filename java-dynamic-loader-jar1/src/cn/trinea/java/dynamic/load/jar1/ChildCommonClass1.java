package cn.trinea.java.dynamic.load.jar1;

import cn.trinea.java.dynamic.load.common.CommonClass;

public class ChildCommonClass1 extends CommonClass {

    @Override
    public String getString() {
        return s == null ? "ChildCommonClass1" : s;
    }

    public ChildCommonClass1(String s) {
        super(s);
    }

    public ChildCommonClass1() {
        super(null);
    }

}
