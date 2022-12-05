<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<jsp:include page="head.jsp"/>
<body style="text-align: center;">
	<h1>用户登录</h1>
	<form action="login" method="post">
		<table style="margin: auto;">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" value="${cookie.username.value }"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value="${cookie.password.value }"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="isSave" />保存密码
					<a href="email.jsp">邮箱登录</a>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登录"/></td>
			</tr>
		</table>	
	</form>
</body>
</html>