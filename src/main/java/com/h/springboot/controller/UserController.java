package com.h.springboot.controller;

import com.h.springboot.bean.User;
import com.h.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/user/{id}")
    @Cacheable(value = "user",key ="#id")
    public User showUser(@PathVariable("id") Integer id){
        System.out.println(id);
        User user = userMapper.selByid(id);
        System.out.println(user);

        return user;
    }
    @GetMapping("/update")
    @CachePut(value = "user",key = "#result.id")
    public User updateUser(User user){
        userMapper.updateUser(user);
        return user;
    }


}
