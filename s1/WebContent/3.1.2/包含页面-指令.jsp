<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
这是网页内容！
指令的导入是代码原样包含（代码可能存在冲突）
<%
	//int x = 1; 变量重复定义
%>

<%@ include file="footer.jsp" %> 
</body>
</html>