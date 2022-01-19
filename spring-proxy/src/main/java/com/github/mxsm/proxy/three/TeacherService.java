package com.github.mxsm.proxy.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @date 2021/12/8 22:58
 * @Since 1.0.0
 */
@Component
public class TeacherService {

    @Autowired
    private UserService userService;

    @Log
    public void testUser(){
        userService.user();
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
