package com.github.mxsm.cglib.verification;

/**
 * @author mxsm
 * @Date 2019/8/3 15:41
 * description:
 */
public class TargetObject {

    public String method1(String paramName) {
        return paramName;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }

}
