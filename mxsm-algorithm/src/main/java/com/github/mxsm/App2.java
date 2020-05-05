package com.github.mxsm;

/**
 * Hello world!
 */
public class App2 {
    public static void main(String[] args)  throws Exception{
        MxsmClassLoader classLoader1 = new MxsmClassLoader("MxsmClassLoader1");
        classLoader1.setPath("C:\\Users\\mxsm\\Desktop\\test\\");
        Class<?> class1 = classLoader1.loadClass("com.github.mxsm.algorithm.A");

        MxsmClassLoader classLoader2 = new MxsmClassLoader("MxsmClassLoader2");
        classLoader2.setPath("C:\\Users\\mxsm\\Desktop\\test\\");
        Class<?> class2 = classLoader2.loadClass("com.github.mxsm.algorithm.A");

        System.out.println(class1.getClassLoader());
        System.out.println(class2.getClassLoader());
        System.out.println(class1 == class2);

        Object a1 = class1.newInstance();
        Object a2 = class2.newInstance();

        class1.getMethod("setA", Object.class).invoke(a1, a2);

    }
}
