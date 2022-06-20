package com.lin.controller;

import com.google.protobuf.compiler.PluginProtos;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.Servlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","zhizhi");
        return "/test";
    }

    //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile则为数组即可
    @RequestMapping("/upload")
    public String fileUpload(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println("fileName: "+fileName);

        String realPath = request.getSession().getServletContext().getRealPath("upload");
//        String realPath = "B:\\FreeTool\\linshi";
        File uploadPath = new File(realPath);
        if (!uploadPath.exists()){
            uploadPath.mkdir();
            System.out.println("uploadPath mkdir success!");
        }else {
            System.out.println("uploadPath is already exists!");
        }
        System.out.println("the uploadPath is "+uploadPath);

        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = new FileOutputStream(new File(uploadPath,fileName));
        int readLen = 0;
        byte[] buf = new byte[1024];
        while ( (readLen = inputStream.read(buf)) != -1){
            outputStream.write(buf,0,readLen);
            outputStream.flush();
        }
        System.out.println("Upload Success!");
        outputStream.close();
        inputStream.close();
        return "redirect:/";
    }

    @RequestMapping("download/{fileN}")
    public String downloadFile(@PathVariable String fileN,HttpServletResponse response) throws IOException {
        String path = "B:\\FreeTool\\linshi";
        String fileName = fileN;
        File file = new File(path,fileName);
        if (!file.exists()){
            System.out.println("file :" +file.getName()+" is not exists!");
            return "redirect:/";
        }
        response.reset();//设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        response.setHeader("Content-Disposition",
                "attachment;fileName="+URLEncoder.encode(fileName, "UTF-8"));

        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        System.out.println("download fileName : "+file.getName());
        int readLen = 0;
        byte[] buf = new byte[1024];
        while ((readLen = inputStream.read(buf)) !=-1){
            outputStream.write(buf,0,readLen);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();

        return "redirect:/";
    }
}
