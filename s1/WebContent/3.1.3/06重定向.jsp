<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重定向</title>
</head>
<body>
此页面不能请假，需要辅导员才可以res.jsp
<% response.sendRedirect("res.jsp"); %>
</body>
</html>