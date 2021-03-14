package com.github.mxsm;

import com.github.mxsm.config.SpringBootStrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStrap.class,args);
    }
}
