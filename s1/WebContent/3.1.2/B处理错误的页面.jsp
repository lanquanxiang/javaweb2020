<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理错误</title>
</head>
<body>
<%
	response.setStatus(200);
%>
你的程序出错了，需要进行修复。<br/>
<%=exception %>
</body>
</html>