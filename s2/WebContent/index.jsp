<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登记</title>
</head>
<body>
<form action="todo" method="post" >
	姓名:<input type="text" name="username"/>	<br/>
	年龄:<input type="text" name="age"/><br/>
	爱好:<input type="checkbox" name="hobby" value="C">C
	<input type="checkbox" name="hobby" value="C++">C++
	<input type="checkbox" name="hobby" value="Java">Java
	<input type="checkbox" name="hobby" value="Python">Python
	<input type="submit" value="登记">
</form>
</body>
</html>