package com.github.mxsm;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MxsmClassLoader extends ClassLoader {

    private String classLoaderName;

    private String path;

    private static final String SUFFIX =  ".class";

    public MxsmClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = new byte[0];
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws IOException {

        return FileUtils.readFileToByteArray(new File(getPath() + name.replace(".", "\\")+SUFFIX));

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

/*    @Override
    public String toString() {
        return "MxsmClassLoader{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }*/
}
