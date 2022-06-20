package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginInterceptor {
    @RequestMapping("/toMain")
    public String toMain(){
        return "/main";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestParam("username") String username,@RequestParam("password") String password){
        HttpSession session = request.getSession();
        session.setAttribute("userInfo",username);
        return "/main";
    }

    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
