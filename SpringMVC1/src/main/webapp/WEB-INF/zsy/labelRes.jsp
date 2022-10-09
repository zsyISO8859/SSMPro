<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2022/6/17
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fm:form modelAttribute="user" action="update2" method="put">
    <fm:input path="name"/> <br>
    <fm:input path="age"/> <br>
    <fm:radiobutton path="gender" value="1" label="男"/>
    <fm:radiobutton path="gender" value="0" label="女"/> <br>
    <fm:select path="pet.id" items="${petList}" itemValue="id" itemLabel="name" /> <br>
    <fm:checkboxes path="hobby" items="${hobbyList}"/> <br>
    <input type="submit" value="修改">
</fm:form>
</body>
</html>
