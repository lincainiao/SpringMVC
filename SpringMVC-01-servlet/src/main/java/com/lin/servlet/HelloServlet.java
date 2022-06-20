package com.lin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取前端数据
        String method = req.getParameter("method");
        if (method.equals("add")){
            req.getSession().setAttribute("msg","add method");
        }else if (method.equals("delete")){
            req.getSession().setAttribute("msg","delete method");
        }
        // 2.调用业务层

        // 3.重定向或转发
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);
//        resp.sendRedirect("/WEB-INF/jsp/test.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
