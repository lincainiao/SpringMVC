package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {


    @RequestMapping("/add1")
    // 原来的 : http://localhost:8080/add1?a=1&b=6
    public String add1(Model model,int a,int b){
        int ans = a+b;

        model.addAttribute("msg","result is "+ans);
        return "/test";
    }
    @RequestMapping("/add2/{a}/{b}")
    // 使用RestFul : http://localhost:8080/add2/1/2
    public String add2(Model model,@PathVariable int a,@PathVariable int b){
        int ans = a+b;

        model.addAttribute("msg","result is "+ans);
        return "/test";
    }

    @GetMapping("/add3/{a}/{b}")
    // 相当于 @RequestMapping(name = "/add3/{a}/{b}",method = RequestMethod.GET)，通过地址栏直接传参数为get方法
    // http://localhost:8080/add3/4/2
    public String add3(Model model,@PathVariable int a,@PathVariable int b){
        int ans = a+b;
        model.addAttribute("msg","result is "+ans);
        return "/test";
    }
}
