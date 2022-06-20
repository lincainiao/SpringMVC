package com.lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsonTest {
    @RequestMapping("/json5")
    public String json5(Model model) throws JsonProcessingException {
        User user = new User("zsy",20,"black silk");
        String userJson = new ObjectMapper().writeValueAsString(user);
        model.addAttribute("user",userJson);
//        System.out.println(userJson);
        return "/test";
    }
}
