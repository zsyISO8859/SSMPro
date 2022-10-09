<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2022/6/14
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>secondName=====${name}</h1>

<form action="${pageContext.request.contextPath}/update2" method="post">
    姓名：<input type="text" name="name" value="${user.name}">${name} <br>
    年龄：<input type="text" name="age" value="${user.age}">${age} <br>
    性别：<input type="text" name="gender" value="${user.gender}"> ${gender}<br>
    电话：<input type="text" name="phone" value="${user.phone}">${phone} <br>
    邮箱：<input type="text" name="email" value="${user.email}">${email} <br>
    <input type="submit" value="修改">
</form>
<fm:errors path="name"></fm:errors>
<form action="${pageContext.request.contextPath}/update2" method="post">
    姓名：<input type="text" name="name" value="${user.name}"><fm:errors path="name"></fm:errors> <br>
    年龄：<input type="text" name="age" value="${user.age}"><fm:errors path="age"/> <br>
    性别：<input type="text" name="gender" value="${user.gender}"> ${gender}<br>
    电话：<input type="text" name="phone" value="${user.phone}">${phone} <br>
    邮箱：<input type="text" name="email" value="${user.email}">${email} <br>
    <input type="submit" value="修改">
</form>
</body>
</html>
