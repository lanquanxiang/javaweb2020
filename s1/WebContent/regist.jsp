<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<style type="text/css">
span{
	color:red;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function checkdata() {
		$("span").html("");
		var username = document.querySelectorAll("input")[0].value;
		var password = document.querySelectorAll("input")[1].value;
		var age = document.querySelectorAll("input")[2].value;
		if(username==""){
			document.querySelectorAll("span")[0].innerHTML="用户名不能为空!";
			return false;
		}
		if(!(/^\w{6,}$/.test(password))){
			document.querySelectorAll("span")[1].innerHTML="密码长度不够!";
			return false;
		}
		if(age==""||isNaN(age)){
			document.querySelectorAll("span")[2].innerHTML="年龄不正确!";
			return false;
		}
	}
</script>
</head>
<body>
<form action="" method="post" onsubmit="return checkdata()">
	姓名：<input type="text" name="username"/><span></span><br/>
	密码：<input type="password" name="password"/><span></span><br/>
	年龄：<input type="text" name="age"/><span></span><br/>
	<input type="submit" value="注册"/>
</form>
</body>
</html>