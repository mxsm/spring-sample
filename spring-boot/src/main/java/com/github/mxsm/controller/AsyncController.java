package com.github.mxsm.controller;

import com.github.mxsm.processor.Test;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @Date 2021/3/16
 * @Since
 */
@RestController
@RequestMapping("/log")
public class AsyncController {

    @Autowired
    private Test test;

    @PostMapping("/user")
    public long currentTime1(@RequestParam(value = "name",required = false)String name,
        @RequestBody User user){
        test.addUser(user);
        return System.currentTimeMillis();
    }




}
