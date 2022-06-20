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
<h1>首页</h1>
${userInfo}
<p>
    <a href="${pageContext.request.contextPath}/user/logOut">注销</a>
</p>
</body>
</html>
