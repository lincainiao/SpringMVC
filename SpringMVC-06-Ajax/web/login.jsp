<%--
  Created by IntelliJ IDEA.
  User: 林光亮
  Date: 2022/5/2
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>
        function a1(){
            $.post({
                url : "${pageContext.request.contextPath}/a3",
                data : {"username" : $("#username").val()},
                success : function (data){
                    console.log(data)
                    if (data.toString() === "OK!"){
                        $("#userinfo").css("color","green");
                    }else {
                        $("#userinfo").css("color","red");
                    }
                    $("#userinfo").html(data);
                }
            })
        }
        function a2(){
            $.post({
                url : "${pageContext.request.contextPath}/a3",
                data : {"password" : $("#password").val()},
                success : function (data){
                    console.log(data)
                }
            })
        }
    </script>
    <title>Title</title>
</head>
<body>
<p>
    用户名：<input type="text" id="username" onblur="a1()">
    <span id="userinfo"></span>
</p>
<p>
    密码：<input type="password" id="password" onblur="a2()">
    <span id="pwdinfo"></span>
</p>
</body>
</html>
