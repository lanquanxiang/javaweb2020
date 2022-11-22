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
		var username = $(":text").val();	
		if(username==""){
			$("#note").html("用户名不能为空!");
			return;
		}
		$.get(
			"checkusername",
			{
				"name":username,
				"time":new Date().getTime()
			},
			function (data) {
				$("#note").html(data);
			}
		);
	}
	
	function  newImage() {
		$("img").attr("src","showimage?time="+new Date().getTime());
	}
	function  newCNImage() {
		$("img").attr("src","showimage?type=cn&time="+new Date().getTime());
	}
</script>
</head>
<body style="text-align: center;">
<jsp:include page="head.jsp"/>
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
						<img alt="验证码加载失败" src="showimage" onclick="newImage()"/><a href="#" onclick="newCNImage()">中文</a>
					</span>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="注册"/>
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>