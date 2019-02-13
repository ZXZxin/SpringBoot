package com.zxin.springboot.controller;

import com.zxin.springboot.entity.User;
import com.zxin.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
//        User user = userRepository.getOne(id); // 不是findOne()(SpringBoot1.0的)
        User user = userRepository.findAll().get(0); // 不是findOne()(SpringBoot1.0的)

        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
