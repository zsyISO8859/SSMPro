<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2022/6/16
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/action1">action1</a><br>
<a href="${pageContext.request.contextPath}/action2">action2</a><br>
<a href="${pageContext.request.contextPath}/action3">requestMethod</a><br>
<form action="${pageContext.request.contextPath}/action3" method="post">
    <input type="submit" value="提交">
</form>
<br>
<a href="${pageContext.request.contextPath}/action4?name=itlike&age=2">params</a><br>
<a href="${pageContext.request.contextPath}/action5">header</a><br>
<a href="${pageContext.request.contextPath}/111/asd/asda/action6/12">ant</a><br>
</body>
</html>
