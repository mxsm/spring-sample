package com.github.mxsm.springboot.protobuf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @date 2022/1/29 10:33
 * @Since 1.0.0
 */
@RestController
public class ThreadPoolController {

    @Autowired
    private ThreadPoolService threadPoolService;

    @GetMapping(value = "/createThreadPool")
    public boolean createThreadPool(){
        return threadPoolService.createThread();
    }

}
