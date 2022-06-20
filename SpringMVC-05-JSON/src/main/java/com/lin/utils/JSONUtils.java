package com.lin.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JSONUtils {

    // 时间json工具，根据参数个数调用方法
    public static String getJson(Object object) throws JsonProcessingException {
        // 加入默认是时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd-HH:mm:ss");
        return getJson(object,simpleDateFormat);
    }

    // 有时间格式
    public static String getJson(Object object,SimpleDateFormat simpleDateFormat){
        ObjectMapper mapper = new ObjectMapper();
        // 关闭默认时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        // 定义默认时间格式
        mapper.setDateFormat(simpleDateFormat);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
