<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请求转发</title>
</head>
<body>
我是班长，但是我的没有权利批假，但是我现在比较有空，可以将假条转给辅导员。
<%
	request.getRequestDispatcher("../teacher.jsp").forward(request, response);

%>
</body>
</html>