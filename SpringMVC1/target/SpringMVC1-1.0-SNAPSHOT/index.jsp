<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/first.action">请求</a> <br>
<a href="${pageContext.request.contextPath}/second.action">转发</a> <br>

<a href="${pageContext.request.contextPath}/third.action?id=1">传统接收数据</a> <br>
<a href="${pageContext.request.contextPath}/third1.action?id=1&name=zsy">自动注入</a> <br>
<a href="${pageContext.request.contextPath}/third3.action?name=zsy">参数自动注入</a> <br>

<form action="${pageContext.request.contextPath}/third2.action" method="post">
    名称<input type="text" name="name" value="名称"><br>
    年龄<input type="text" name="age" value="年龄"><br>
    爱好： <input type="checkbox" name="hobby" value="basketball">篮球
    <input type="checkbox" name="hobby" value="football">足球
    <input type="checkbox" name="hobby" value="ppq">乒乓球
    <br>-------------宠物----------<br>
    宠物名称<input type="text" name="pet.name"><br>
    宠物颜色<input type="text" name="pet.color">
    <br>-------------宠物----------<br>
    宠物名称<input type="text" name="dogs[1].name"><br>
    宠物颜色<input type="text" name="dogs[1].color">
    <br>-------------宠物----------<br>
    宠物名称<input type="text" name="dogs[0].name"><br>
    宠物颜色<input type="text" name="dogs[0].color">
    <br>
    出生日期<input type="text" name="bor">
    <br><input type="submit" value="发送">

</form>

<br>
<hr>

<button id="btn">按钮对象</button>
<button id="btnList">按钮List</button>
<button id="btnMap">按钮Map</button>

<hr>
<br>

<form id="myform">
    user:<input type="text" name="username"><br>
    age:<input type="text" name="age"><br>
    爱好:<input type="checkbox" name="hobby" value="篮球"> 篮球
    <input type="checkbox" name="hobby" value="乒乓球"> 乒乓球
    <input type="checkbox" name="hobby" value="足球"> 足球
</form>
<input type="button" id="formbtn" value="发送form">
<br>
<hr>
<input type="button" id="btnJsonTest" value="测试Json格式请求">
<hr>
<br>

<form action="${pageContext.request.contextPath}/multipartUpload" method="post" enctype="multipart/form-data">
    <input type="file" value="上传" name="file">
    <input type="submit" value="提交">
</form>

<br>
<a href="${pageContext.request.contextPath}/download/1.jpg">下载 1.jpg</a>
<a href="${pageContext.request.contextPath}/download/名称中国.jpg">下载 名称中国.jpg</a>


<br><br><br><br><br><br><br>
<script>
    $(function () {
        $('#formbtn').click(function () {
            $.fn.serializeJson = function () {
                var serializeObj = {};
                var array = this.serializeArray();
                var str = this.serialize();
                $(array).each(function () {
                    if (serializeObj[this.name]) {
                        if ($.isArray(serializeObj[this.name])) {
                            serializeObj[this.name].push(this.value);
                        } else {
                            serializeObj[this.name] = [serializeObj[this.name], this.value];
                        }
                    } else {
                        serializeObj[this.name] = this.value;
                    }
                });
                return serializeObj;
            };
        })

        $('#formbtn').click(function () {
            let serialize = $('#myform').serializeJson();
            console.log(serialize)
            console.log(JSON.stringify(serialize))
            if (typeof serialize.hobby == "string") {
                serialize.hobby = new Array(serialize.hobby)
            }
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/formJson",
                data: JSON.stringify(serialize),
                dataType: 'Json',
                contentType: 'application/json',
                success: function (data) {
                    alert("成功")
                    console.log(data)
                },
                error: function (data) {
                    alert("失败")
                    console.log(data)
                }

            })
        })

        $('#btn').click(function () {
            $.post("${pageContext.request.contextPath}/getJson", function (res) {
                console.log(res)
            })
        });
        $('#btnList').click(function () {
            $.post("${pageContext.request.contextPath}/getJsonList", function (res) {
                console.log(res)
            })
        });
        $('#btnMap').click(function () {
            $.post("${pageContext.request.contextPath}/getJsonMap", function (res) {
                console.log(res)
            })
        });

        $('#btnJsonTest').click(function () {
            var data = {"name": "zyp", "age": 10}
            $.ajax({
                url: "${pageContext.request.contextPath}/sendJsonTest",
                data: JSON.stringify(data),
                dataType: "Json",
                contentType: "application/json",
                type: "post",
                success: function (res) {
                    alert("成功")
                    console.log(res);
                },
                error: function (data) {
                    alert("失败")
                    console.log(data)
                }
            })
        })
    })
</script>
</body>
</html>