package com.github.mxsm.nacos;

import com.github.mxsm.nacos.annotation.EnableNacosConfig;
import com.github.mxsm.nacos.annotation.NacosProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848", namespace = "1ef58b42-2e3c-4c11-9698-ce8e9c8e4e63"))
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }
}
