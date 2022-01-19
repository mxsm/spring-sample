package com.github.mxsm.proxy.three;

import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @date 2021/12/8 22:57
 * @Since 1.0.0
 */
@Component
public class UserServiceImpl implements UserService {

    private String name;

    private String address;

    @Override
    @Log
    public void user() {
        System.out.println(1111);
    }
}
