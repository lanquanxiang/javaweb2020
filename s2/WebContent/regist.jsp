<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css">
	body{
		text-align: center;
	}
	table{
		margin: auto;
	}
</style>
</head>
<jsp:include page="head.jsp"/>
<body>
<h1>用户注册</h1>
<form action="regist" method="post">
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="注册"/></td>
		</tr>
	</table>
</form>
</body>
</html>