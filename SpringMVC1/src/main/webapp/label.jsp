<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2022/6/17
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>
<a href="${pageContext.request.contextPath}/update">label</a> <br>

<form action="${pageContext.request.contextPath}/update2" method="post">
    姓名：<input type="text" name="name" value="${user.name}">${name} <br>
    年龄：<input type="text" name="age"> <br>
    性别：<input type="text" name="gender"> <br>
    电话：<input type="text" name="phone"> <br>
    邮箱：<input type="text" name="email"> <br>
    <input type="submit" value="修改">
</form>
</body>
</html>
