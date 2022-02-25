package com.github.mxsm;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * @author mxsm
 * @date 2022/2/24 23:20
 * @Since 1.0.0
 */
public class TomcatBootstrap {

    public static void main(String[] args) throws Exception{
        //第一部分
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        //第二部分
        Context ctx = tomcat.addWebapp("", new File("java-sample/src/main/webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(
            new DirResourceSet(resources, "/WEB-INF/classes", new File("java-sample/target/classes").getAbsolutePath(), "/"));
        ctx.setResources(resources);

        //第三部分
        tomcat.start();
        tomcat.getServer().await();
    }
}
