<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱登录</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function sendemail() {
		//校验姓名和邮箱的完整性和合法性
		$.post(
			"sendemail",
			{
				"username":$("input[name='username']").val(),
				"email":$("input[name='email']").val()
			},
			function (data) {
				$(".note").html(data);//操作结果
			}
		)
	}
</script>
</head>
<body style="text-align: center;">
<jsp:include page="head.jsp"/>
	<h1>邮箱登录</h1>
	<form action="loginemail" method="post">
		<table style="margin: auto;">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" /><span class="note" style="position: absolute;"></span></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input type="text" name="checkcode"/>
					<input type="button" value="发送邮件" style="position: absolute;" onclick="sendemail()">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="登录"/>
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>