<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息的存储</title>
</head>
<body>
<%
	request.setAttribute("username", "zhangsan");
	session.setAttribute("username", "lisi");
	
	

%>
现在的用户名是:<%=request.getAttribute("username") %>

</body>
</html>