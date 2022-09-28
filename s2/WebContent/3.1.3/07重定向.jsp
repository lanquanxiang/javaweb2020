<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重定向</title>
</head>
<body>
我是班长，但是我的没有权利批假，但是我现在没有空，你需要自己去找辅导员。
<%
	response.sendRedirect("../teacher.jsp");

%>
</body>
</html>