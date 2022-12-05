<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱登录</title>
</head>
<jsp:include page="head.jsp"/>
<body style="text-align: center;">
	<h1>邮箱登录</h1>
	<form action="loginemail" method="post">
		<table style="margin: auto;">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" />
					<span style="position: absolute;"></span>
				</td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input type="text" name="checkcode" />
					<input type="button" value="发送验证码" style="position: absolute;">
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