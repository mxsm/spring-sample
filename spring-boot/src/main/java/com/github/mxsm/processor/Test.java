package com.github.mxsm.processor;

import com.github.mxsm.controller.User;
import com.github.mxsm.log.annotation.Log;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2021/4/19
 * @Since
 */
@Component
public class Test {

    public void test(){
        System.out.println(1111);
    }

    @Log(template = "用户${#user.name}信息：${@test.getName(#user)}")
    public boolean addUser(User user){

        return  true;
    }

    public String getName(User user){

        return  user.getName();
    }

}
