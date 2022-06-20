<%--
  Created by IntelliJ IDEA.
  User: 林光亮
  Date: 2022/5/1
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>
      function a1(){
        $.post({
          // 请求
          url : "${pageContext.request.contextPath}/a1",
          // data以键值对的形式
          data : {"name":$("#username").val()},
          // callback : 回调函数，这里的data为后端返回的data
          success : function (dataFromBack){
            console.log(dataFromBack)
          },
          error : function (){
          }
        })
      }
    </script>
    <title>$Title$</title>
  </head>

  <body>
  <%--失去焦点的时候，发起一个请求到后台--%>
  <input type="text" id="username" onblur="a1()">
  </body>
</html>
