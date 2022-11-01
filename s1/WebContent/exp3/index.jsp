<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/todo" method="post">
	姓名：<input type="text" name="username"/><br/>	
	年龄：<input type="text" name="age"/><br/>
	爱好：<input type="checkbox" name="hobby" value="C">C
	<input type="checkbox" name="hobby" value="C++">C++
	<input type="checkbox" name="hobby" value="C">java
	<input type="checkbox" name="hobby" value="python">python
	<input type="submit" value="登记"/>
</form>
<a href="show.jsp">查看所有登记</a>
</body>
</html>