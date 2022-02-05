package com.github.mxsm.controller;

import org.springframework.stereotype.Service;

/**
 * @author mxsm
 * @date 2022/2/4 14:32
 * @Since 1.0.0
 */
@Service
public class ArthasServiceImpl {

    public void testArthas(){
        doHandle1();
    }

    private void doHandle1(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 1000000; i++){
            builder.append(i);
        }
    }
}
