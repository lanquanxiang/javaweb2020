<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输出</title>
</head>
<body>
<%
	out.print("1");
	out.print("2");
	response.getWriter().print("2");

%>
</body>
</html>