package com.github.mxsm;

import com.github.mxsm.annotation.MxsmComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mxsm
 * @Date 2019/7/1 0:21
 * description:
 */
@SpringBootApplication
@MxsmComponentScan(basePackages = "com.github.mxsm")
public class SpringMxsmValueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMxsmValueApplication.class,args);
    }

}
