package com.lin.controller;

import com.lin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 处理处理方式
// 从前端获取数据
// 将数据返回前端
@Controller
public class DataProcess {
    @GetMapping("/dp1")
    // http://localhost:8080/dp1?name=zhizhi
    public String dataProcess1(@RequestParam("username") String name, Model model){
        // 1. 接收前端参数
        System.out.println("name : "+name);
        // 2. 将返回的结果传给前端
        model.addAttribute("msg",name);
        // 3. 视图跳转
        return "/test";
    }
    // 前端接收的是一个对象
    // http://localhost:8080/dp2?id=1&name=zhizhi&dress=black%20silk
    // User{id=1, name='zhizhi', dress='black silk'}
    /*
    * 1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    * 2.假设传递的是一个User，匹配User对象中的字段名，如果名字一致就OK，否则无法匹配
    * */
    @GetMapping("/dp2")
    public String dataProcess2(User user){
        System.out.println(user);
        return "/test";
    }

    // 处理乱码问题
    @PostMapping("/dp4")
    public String dataProcess4(Model model,@RequestParam("name") String name){
        // 当前端输入为中文时，输出的为乱码
        model.addAttribute("msg",name);
        return "/test";
    }


    @GetMapping("/dp3")
    public String modelMapTest( ModelMap map,@RequestParam("username") String name){
        map.addAttribute("msg",name);
        return "/test";
    }
}
