<%--
  Created by IntelliJ IDEA.
  User: 林光亮
  Date: 2022/5/2
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="提交">
</form>

</body>
</html>
