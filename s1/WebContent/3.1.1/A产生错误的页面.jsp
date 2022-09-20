<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="B处理错误的页面.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产生错误</title>
</head>
<body>
<%
	//int x = 1/0;
	int[] x = new int [5];
	x[10]=1;

%>
</body>
</html>