<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请求转发</title>
</head>
<body>
此页面不能请假，需要转给辅导员res.jsp
<% request.getRequestDispatcher("res.jsp").forward(request, response); %>
</body>
</html>