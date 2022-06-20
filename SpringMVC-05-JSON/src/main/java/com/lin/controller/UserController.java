package com.lin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lin.pojo.User;
import com.lin.utils.JSONUtils;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.ModuleElement;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController // 被该注解的类的所有方法，值会返回字符串
public class UserController {

    @ResponseBody// 不会走视图解析器，会直接返回字符串
    @GetMapping("/json1")
    public String json1(Model model) throws JsonProcessingException {
        // jackson包下的ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 创建对象
        User user = new User("芝芝",23,"black silk");

        // 将对象转成JSON字符串
        String s = mapper.writeValueAsString(user);
        return s;
    }

    @ResponseBody// 不会走视图解析器，会直接返回字符串
    @GetMapping("/json2")
    public String json2(Model model) throws JsonProcessingException {
        // jackson包下的ObjectMapper
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhizhi",23,"black silk"));
        userList.add(new User("mxy",23,"nurse's frock"));
        userList.add(new User("zsy",23,"skinny jeans"));
        userList.add(new User("ytm",23,"maid's frock"));

        // 将对象转成JSON字符串
        String s = JSONUtils.getJson(userList);
        return s;
    }

    @ResponseBody// 不会走视图解析器，会直接返回字符串
    @GetMapping("/json3")
    public String json3(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        // 将对象转成JSON字符串
//        String s = new ObjectMapper().writeValueAsString(simpleDateFormat.format(date));

        // 使用ObjectMapper格式化
        // 关闭默认时间戳格式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(simpleDateFormat);
        String s = mapper.writeValueAsString(date);
//        return s;

        // 使用JSONUtils工具类实现代码复用
        String s1 = JSONUtils.getJson(date,simpleDateFormat);
        return s1;
    }

    @ResponseBody// 不会走视图解析器，会直接返回字符串
    @GetMapping("/json4")
    public String json4(Model model) throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhizhi",23,"black silk"));
        userList.add(new User("mxy",23,"nurse's frock"));
        userList.add(new User("zsy",23,"skinny jeans"));
        userList.add(new User("ytm",23,"maid's frock"));
        String s = JSON.toJSONString(userList);
        return s;
    }

    @Test
    public void test(){
        //创建一个对象
        User user1 = new User("秦疆1号", 3, "男");
        User user2 = new User("秦疆2号", 3, "男");
        User user3 = new User("秦疆3号", 3, "男");
        User user4 = new User("秦疆4号", 3, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);
    }
}
