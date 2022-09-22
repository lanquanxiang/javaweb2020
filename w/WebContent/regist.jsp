<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css">
	span{
		color: red;
	}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">	
	function check() {
		$("span").html("");
		var username = document.getElementsByName("username")[0].value;
		var password = document.getElementsByTagName("input")[1].value;
		var age = $("input").eq(2).val();
		if(username==""){
			document.querySelectorAll("span")[0].innerHTML="用户名不能为空";
			return false;
		}
		if(!(/^\w{6,}$/.test(password))){
			document.querySelectorAll("span")[1].innerHTML="密码长度不足6位";
			return false;
		}
		if(age==""||isNaN(age)){
			document.querySelectorAll("span")[2].innerHTML="年龄不符合要求";
			return false;
		}
		return true;
	}

</script>
</head>
<body>
<form action="" method="post" onsubmit="return check()">
姓名:<input type="text" name="username"/><span></span><br/>
密码:<input type="password" name="password"/><span></span><br/>
年龄:<input type="text" name="age"/><span></span><br/>
<input type="submit" value="注册"/> 

</form>
</body>
</html>