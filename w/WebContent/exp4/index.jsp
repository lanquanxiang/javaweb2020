<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登记</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jdbc2" method="post" >
	姓名:<input type="text" name="username"/>
	<input type="submit" value="查询">
</form>
</body>
</html>