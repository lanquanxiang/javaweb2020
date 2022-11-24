<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function fun() {
	$("#note").html("");
	var username = $(":text").eq(0).val();
	if(username==""){
		$("#note").html("用户名不能为空!");
		return;
	}
	$.get(
		"checkusername",
		{"username":username,
			"time":new Date().getTime()
		},
		function(data){
			$("#note").html(data);
		}
	);
}

function newCaptcha() {
	$("img").attr("src","getcaptcha?time="+new Date().getTime());
}
function newCNCaptcha() {
	$("img").attr("src","getcaptcha?type=cn&time="+new Date().getTime());
}
</script>

</head>
<jsp:include page="head.jsp"/>
<body style="text-align: center;">
	<h1>用户注册</h1>
	<form action="regist" method="post">
		<table style="margin: auto;">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" onchange="fun()"/><span id="note" style="position: absolute;"></span></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input type="text" name="captcha"/>
					<span style="position: absolute;">
						<img alt="验证码加载失败" src="getcaptcha" title="点击刷新" onclick="newCaptcha()">
						<a href="#" onclick="newCNCaptcha()">中文验证码</a>
					</span>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="注册"/></td>
			</tr>
		</table>	
	</form>
</body>
</html>