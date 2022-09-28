<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
	Date date = new Date();
	int year = date.getYear();
	
%>
这是版权信息copyright by XXX！2020-<%=year+1900 %>
</body>
</html>