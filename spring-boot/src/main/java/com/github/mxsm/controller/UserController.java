package com.github.mxsm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mxsm
 * @date 2022/2/25 21:21
 * @Since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * type: 把type看成一个32bit,从低位到高位分别表示id, 名称，年龄，性别，手机号码，家庭地址。
     * 每一位0表示不显示数据到前端，1表示显示数据到前端。
     * 例子:
     * 二进制:111111表示全部显示换算成十进制整数为63,表示全部显示
     * 二进制:101111表示全部显示换算成十进制整数为47,除了名称其他都显示
     *
     * 前端用或运算来传入：int sum = 0;
     * sum |= (1<<2) --这个表示显示性别
     *
     * @param id
     * @param type
     * @return
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id, @RequestParam(value = "type", defaultValue = "63") int type){

        //根据设计那么type如何处理呢？
        User user = new User();

        //判断是否显示家庭住址
        if((type & 1) != 0){
            //拼接SQL--模拟
            user.setAddress("家庭住址");
        }

        //判读是否显示手机号码
        if((type & (1<<1)) != 0){
            //拼接SQL--模拟
            user.setMoblie("手机号码");
        }

        //判读是否显示性别
        if((type & (1<<2)) != 0){
            //拼接SQL--模拟
            user.setSex((short) 1);
        }

        //判读是否显示年龄
        if((type & (1<<3)) != 0){
            //拼接SQL--模拟
            user.setAge(10);
        }

        //判读是否显示名称
        if((type & (1<<4)) != 0){
            //拼接SQL--模拟
            user.setName("蚂蚁背大象");
        }

        //判读是否ID
        if((type & (1<<5)) != 0){
            //拼接SQL
            user.setId(id);
        }

        return user;
    }

}
