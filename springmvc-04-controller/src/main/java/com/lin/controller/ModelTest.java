package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class ModelTest {

    @RequestMapping("/m1")
    public String test(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        model.addAttribute("msg",session.getId());
        return "/test";
    }
    @RequestMapping("/m2")
    // 没有视图解析器
    public String test(Model model){
        model.addAttribute("msg","zhizhi");
        // 默认为转发
//        return "/WEB-INF/jsp/test.jsp";
        // 显示定义为转发
//        return "forward:/WEB-INF/jsp/test.jsp";
        // 重定向
        return "redirect:/formTest.jsp";
    }
}
