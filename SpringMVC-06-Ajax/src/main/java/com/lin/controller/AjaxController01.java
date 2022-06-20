package com.lin.controller;

import com.lin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController01 {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","ajax");
        return "/test";
    }

    @RequestMapping("/a1")
    // name对应Ajax中data中的键
    public void a1(String name, Model model, HttpServletResponse response) throws IOException {
        if (name.equals("zhizhi")){
            response.getWriter().write("zhizhi");
        }else {
            response.getWriter().write("zhizhizhi");
        }
    }


    @RequestMapping("/a2")
    public List<User> a2(Model model){
        List<User> userList = new ArrayList<>();
        // 添加数据
        userList.add(new User(1,"zhizhi","123456"));
        userList.add(new User(2,"zsy","123456"));
        userList.add(new User(3,"wxy","123456"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String username,String password){
        String info = "";
        if (username != null){
            if (username.equals("zhizhi")){
                info = "OK!";
            }else {
                info = "FALSE!";
            }
        }
        if (password != null) {
            if (password.equals("123456")){
                info = "OK!";
            }else {
                info = "False!";
            }
        }
        return info;
    }
}
