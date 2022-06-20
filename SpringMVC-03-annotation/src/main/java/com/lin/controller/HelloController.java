package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        // 封装数据
        model.addAttribute("msg","Hello!");
        return "hello"; // 被视图解析器处理
    }
}
