package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 这个类被spring托管，
// 被这个注解的类，里面的所有方法，如果返回值为string，并且具有具体的页面可以转跳，那么就会被视图解析器解析
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("msg", "Hello!");
        return "/hello"; // 被视图解析器处理
    }
}