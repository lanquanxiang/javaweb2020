<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自动刷新</title>
</head>
<body>
<%
	//response.setHeader("refresh", "1"); 每秒刷新1次
	//3秒之后跳转到学校首页
	response.setHeader("refresh", "3;url=http://www.pzhu.cn");
%>
<%=new Date().toLocaleString() %>
</body>
</html>