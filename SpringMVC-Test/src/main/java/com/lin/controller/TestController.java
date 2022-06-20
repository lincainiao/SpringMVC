package com.lin.controller;
import com.lin.constant.Constant;
import com.lin.pojo.User;
import com.lin.service.LoginUser;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @PostMapping("/hello")
    public String hello(@RequestParam("id") String id,@RequestParam("pwd") String pwd, Model model){
        // 获取前端数据
//        System.out.println("id : "+id);
//        System.out.println("pwd : "+pwd);
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        // 获取登录用户
        User user = LoginUser.getLoginUser(map);
        // 判断用户输入的账户对应的密码是否正确
        // 输入的账号无法在数据库中找到
        if (user == null) {
            model.addAttribute("msg","there is no such user!");
            return "/test";
        }
        // 密码正确
        if (pwd.equals(user.getPwd())){
//            model.addAttribute(Constant.USER_SESSION,user);
            model.addAttribute("msg","welcome "+user.getName());
            System.out.println();
            return "/hello";
        }else {
            model.addAttribute("msg","the pwd is wrong!");
            return "/test";
        }

//        model.addAttribute("msg","zhizhi");
//        return "/hello";
    }
}
