<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登记成功</title>
</head>
<body>
<h1>登记成功！你的登记信息是：</h1>
姓名：${userinfo.username}<br/>
年龄：${userinfo.age}<br/>
爱好：${userinfo.hobby}<br/>
<a href="#">查看所有的登记信息</a><br/>
<a href="#">继续登记其他用户信息</a>
</body>
</html>