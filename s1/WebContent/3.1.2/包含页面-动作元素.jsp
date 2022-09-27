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
<%
	int x = 1; //不会变量重复定义
%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>