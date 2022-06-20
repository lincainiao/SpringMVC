<%--
  Created by IntelliJ IDEA.
  User: 林光亮
  Date: 2022/5/3
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" name="提交">
  </form>

  <a href="${pageContext.request.contextPath}/download/527 (2).jpg">download</a>
  </body>
</html>
