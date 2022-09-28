<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源</title>
</head>
<body>
<%
	String ref = request.getHeader("referer");//获取你的来源
	if(ref==null || "".equals(ref) || !Pattern.matches(".*s2.*02.*", ref)){
		//1. 表示直接访问的地址页面
		//2. 表示来源必须包含S2（服务器）02（下载页面）
		out.print("行行好吧，不要盗用我的链接！");
	} else{

%>
如果你能看见这句话，就表示资源已经被下载了。
<%} %>
</body>
</html>