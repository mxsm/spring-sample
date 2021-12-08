package com.github.mxsm.proxy.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author mxsm
 * @date 2021/12/8 22:54
 * @Since 1.0.0
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.github.mxsm.proxy.two"})
public class Config {

    @Bean
    public LogAdvisor init() {
        LogAdvisor logAdvisor = new LogAdvisor(new LogPointcut());
        logAdvisor.setAdvice(new LogAdvice());
        return logAdvisor;
    }

}
