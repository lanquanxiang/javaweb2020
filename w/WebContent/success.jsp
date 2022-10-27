<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登记成功</title>
</head>
<body>
<h1>登记成功！你的登记信息如下：</h1>
姓名：${userinfo.username }<br/>
年龄：${userinfo.age }<br/>
爱好：${userinfo.hobby }<br/>
<a href="#">返回继续登记</a>
<a href="#">查看所有登记信息</a>
</body>
</html>