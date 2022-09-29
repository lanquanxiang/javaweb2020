<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>有空的班长</title>
</head>
<body>
我是班长，但是我不能直接批假，我需要将请假条转给辅导员老师。
<%
	request.getRequestDispatcher("../teacher.jsp").forward(request, response);
%>
</body>
</html>