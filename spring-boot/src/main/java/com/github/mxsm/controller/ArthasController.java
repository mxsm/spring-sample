package com.github.mxsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @date 2022/2/4 14:31
 * @Since 1.0.0
 */
@RestController
@RequestMapping("/arthas")
public class ArthasController {

    @Autowired
    private ArthasServiceImpl arthasService;

    @GetMapping("")
    public long arthas(){
        System.out.println("arthas使用实践-方法调优");
        arthasService.testArthas();
        return System.currentTimeMillis();
    }
}