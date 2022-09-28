<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//为了兼容性和防止不生效，一般全都使用
response.setHeader("Pragma", "No-cache");// 缓存控制：不缓存 HTTP1.0
response.setHeader("Cache-Control", "no-cache"); // 缓存控制：不缓存 HTTP1.1
response.setDateHeader("Expires", 0);	//设置网页过期时间为立即过期
%>
</body>
</html>