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
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function check() {
		var username = $(":text").eq(0).val();
		if(username==""){
			$("span").html("用户名不能为空");
			return;
		}
		$.get(
				"checkusername",
				{
					"username":username,
					"time":new Date().getTime()
				},
				function (data) {
					$("span").html(data);
				}
		);
	}
	function newImage() {
		$("img").attr("src","getImage?time="+new Date().getTime());
	}
	function newCNImage() {
		$("img").attr("src","getImage?type=cn&time="+new Date().getTime());
	}
</script>
</head>
<jsp:include page="head.jsp"/>
<body>
<h1>用户注册</h1>
<form action="regist" method="post">
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="username" onchange="check()"/><span style="position: absolute;"></span></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>验证码</td>
			<td><input type="text" name="captcha"/>
			<span style="position: absolute;">
				<img alt="验证码加载失败" src="getImage" onclick="newImage()"><a href="#" onclick="newCNImage()">中文验证码</a>
			</span></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="注册"/></td>
		</tr>
	</table>
</form>
</body>
</html>