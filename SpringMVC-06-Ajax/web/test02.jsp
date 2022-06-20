<%--
  Created by IntelliJ IDEA.
  User: 林光亮
  Date: 2022/5/2
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>
        function a1(){
            $.post({
                url : "${pageContext.request.contextPath}/a2",
                data : undefined,
                success : function (data){
                    // console.log(data)
                    let html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>"+
                                "<td>"+data[i].id+"</td>"+
                                "<td>"+data[i].name+"</td>"+
                                "<td>"+data[i].pwd+"</td>"+
                            "</tr>"
                    }
                    $("#content").html(html)
                }
            })
        }

    </script>
    <title>Title</title>
</head>
<body>
<input type="button" value="load" id="btn" onclick="a1()">
<table>
    <tr>
        <td>id</td>
        <td>名字</td>
        <td>备注</td>
    </tr>
    <tbody id="content">

    </tbody>
</table>
</body>
</html>
