<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<style type="text/css">
	span{
		color: red;
	}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function check() {
		$("span").html("");
		
		var username = $("input").eq(0).val();
		var password = $("input").eq(1).val();
		var age = $("input").eq(2).val();
		
		if(username==""){
			$("span").eq(0).html("用户名不能为空!");
			return false;
		}
		
		if(!(/^\w{6,}$/.test(password))){
			$("span").eq(1).html("密码长度不够!");
			return false;
		}
		
		if(age==""||isNaN(age)){
			$("span").eq(2).html("年龄只能为数字!");
			return false;
		}
		
	}

</script>
</head>
<body>
<form action="" method="post" onsubmit="return check()">
	姓名:<input type="text" name="username"/><span></span><br/>
	密码:<input type="password" name="password"/><span></span><br/>
	年龄:<input type="text" name="age"/><span></span><br/>
	<input type="submit" value="注册">
</form>
</body>
</html>