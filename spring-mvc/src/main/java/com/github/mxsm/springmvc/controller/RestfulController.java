package com.github.mxsm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mxsm
 * @Date 2019/10/8 23:35
 * description:
 */
@RequestMapping("/restful")
@Controller
public class RestfulController {

    @RequestMapping("/time")
    @ResponseBody
    public String restful(){
        return "TIME:"+System.currentTimeMillis();
    }

}
