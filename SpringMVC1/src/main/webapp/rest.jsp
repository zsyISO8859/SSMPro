<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2022/6/16
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/vue/vue-selected.js"></script>
    <script type="text/javascript" src="js/vue/axios-0.18.0.js"></script>
    <script type="text/javascript" src="js/vue/vuejs-2.5.16.js"></script>
</head>
<body>
<a href="${pageContext.request.contextPath}/rest/1">ant风格</a>
<br>
<form action="${pageContext.request.contextPath}/rest1/1" method="post">
    名称<input type="text" name="name" value="">
    年龄<input type="text" name="age" value="">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="提交">
</form>

</body>

<script type="text/javascript">
    var vm = new Vue({
        el: '#app',
        data: {
            name: 'asd',
            age: 20
        },
        methods: {
            getDatas: function () {
                axios.get("/getData").then(function (response) {
                    console.log(response)
                }).catch(function (reason) {
                    console.log(reason)
                })
            }
        }
    })
</script>

</html>
