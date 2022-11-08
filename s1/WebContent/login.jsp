<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body style="text-align: center;">
<jsp:include page="head.jsp"/>
	<h1>用户登录</h1>
	<form action="login" method="post">
		<table style="margin: auto;">
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
				<td>
					<input type="button" value="注册"/>
					<input type="submit" value="登录"/>
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>