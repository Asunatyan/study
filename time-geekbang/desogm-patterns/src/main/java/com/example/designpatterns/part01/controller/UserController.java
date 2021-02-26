package com.example.designpatterns.part01.controller;


import com.example.designpatterns.part01.common.Metrics;
import com.example.designpatterns.part01.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//应用场景：统计下面两个接口(注册和登录）的响应时间和访问次数
@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    private Metrics metrics = new Metrics();

    @RequestMapping("/register")
    public void register(UserVo user) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimestamp);
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register", respTime);
    }

    @RequestMapping("/login")
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);
        return new UserVo(13, "zs", "1233333333", "123");
    }
}