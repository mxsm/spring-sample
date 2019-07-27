package com.github.mxsm.nacos;

import com.github.mxsm.nacos.annotation.EnableNacosConfig;
import com.github.mxsm.nacos.annotation.NacosProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "192.168.31.150:8848",namespace = "2c1cfce2-1711-4d16-907f-f8a4a148cf23"))
public class NacosApplication {

    public static void main( String[] args ) {
        SpringApplication.run(NacosApplication.class,args);
    }
}
