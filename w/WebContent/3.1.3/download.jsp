<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源地址</title>
</head>
<body>
<%
	String ref = request.getHeader("referer"); //得到来源
	if(ref==null || "".equals(ref) || !Pattern.matches(".*w.*02.*", ref)){
		out.print("行行好，不要来盗我的资源！");
	}else{

%>
这是我们的资源地址，如果你能看见这句话，表示你能够访问资源！
<%} %>
</body>
</html>