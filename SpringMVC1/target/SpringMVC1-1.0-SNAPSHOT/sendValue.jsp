<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2022/6/16
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/sendValue">sendValue</a>
<br>
<a href="${pageContext.request.contextPath}/sendValue1">addAttribute</a>
<br>
<a href="${pageContext.request.contextPath}/sendValue2">addAllAttributes_Map</a>
<br>
<a href="${pageContext.request.contextPath}/sendValue3">addAllAttributes_Collection</a>
<br>
<a href="${pageContext.request.contextPath}/sendValue4">mergeAttributes</a>
<br>
<a href="${pageContext.request.contextPath}/sendValue5">containsAttribute</a>
<br>
<a href="${pageContext.request.contextPath}/SessionAttributes">SessionAttributes</a>
<br>
<a href="${pageContext.request.contextPath}/SessionAttributes1">SessionAttributes1</a>
<br>
<a href="${pageContext.request.contextPath}/SessionAttribute">SessionAttribute</a>
<br>
<hr>
<a href="${pageContext.request.contextPath}/ModelAttribute">ModelAttribute</a><br>
<form action="${pageContext.request.contextPath}/ModelAttribute" method="post">
    名称<input type="text" name="name">
    年龄 <input type="text" name="age">
    <input type="submit" value="提交">
</form>
<br>
<hr>
<form action="${pageContext.request.contextPath}/ModelAttribute1" method="post">
    名称<input type="text" name="name">
    年龄 <input type="text" name="age">
    <input type="submit" value="提交">
</form>

<br>
<a href="${pageContext.request.contextPath}/ModelAttribute2">ModelAttribute2</a>

<br>
<hr>
<form action="${pageContext.request.contextPath}/ModelAttribute3" method="post">
    名称<input type="text" name="name">
    年龄 <input type="text" name="age">
    <input type="submit" value="提交">
</form>
<br>
<a href="${pageContext.request.contextPath}/testView">testView</a>
</body>
</html>
