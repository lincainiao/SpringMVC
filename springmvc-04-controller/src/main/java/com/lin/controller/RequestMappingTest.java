package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/r")
public class RequestMappingTest {

    @RequestMapping("/t1")
    public String string(Model model){
        model.addAttribute("msg","re");
        return "/re";
    }
}
