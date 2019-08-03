package com.github.mxsm.nacos.controller;

import com.github.mxsm.nacos.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @Date 2019/8/3 21:54
 * description:
 */
@RestController
@RequestMapping("/nacosvalue")
public class NacosValueController {

    @Autowired
    @Lazy
    private Student student;

    @GetMapping("/student")
    public String getStudent(){
        return student.getName()+"::"+student.getClassName();
    }
}
