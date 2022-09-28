<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网页时钟</title>
</head>
<body>
<%
	//response.setHeader("refresh", "1"); //不建议使用
	response.setHeader("refresh", "2;url=http://www.pzhu.cn");
%>
<%=new Date().toLocaleString() %>
</body>
</html>