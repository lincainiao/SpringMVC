<%--
  Created by IntelliJ IDEA.
  User: 林光亮
  Date: 2022/4/29
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 id="userName"></h1>
<script>
    let user = ${user};
    document.getElementById("userName").innerText=user.name;
</script>
</body>
</html>
