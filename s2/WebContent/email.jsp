<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱登录</title>
<style type="text/css">
	body{
		text-align: center;
	}
	table{
		margin: auto;
	}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function send() {
	$(".note").html("");
	var username = $("input[name='username']").val();
	var email = $("input[name='email']").val();
	if (username=="" || email=="") {
		$(".note").html("姓名或邮箱不能为空!");
		return;
	}
	/*需要使用正则表达式来验证邮箱的格式 /^/w@/w./w$/.test*/
	$.post(
		"sendEmail",
		{
			"username":username,
			"email":email
		},
		function(data) {
			$(".note").html(data);
		}
	)
}

</script>
</head>
<jsp:include page="head.jsp"/>
<body>
<h1>邮箱登录</h1>
<form action="loginemail" method="post">
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email"/>
				<span style="position: absolute;" class="note"></span>
			</td>
		</tr>
		<tr>
			<td>验证码</td>
			<td><input type="text" name="checkcode"/>
				<button type="button" style="position: absolute;" onclick="send()">发送验证码</button>
			</td>
		</tr>		
		<tr>
			<td></td>
			<td><input type="submit" value="登录"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>