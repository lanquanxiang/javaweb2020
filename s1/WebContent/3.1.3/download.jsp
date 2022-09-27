<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>真实地址</title>
</head>
<body>

<%
	String ref = request.getHeader("referer");//得到你的来源
	System.out.print(ref);
	if(ref==null || !Pattern.matches(".*s1.*", ref)) {  //==null表示没有经过我的网站，直接访问的下载页面;不匹配表示你是从其他网站来的 
		out.print("只能从本网站下载资源，不允许盗用我们的链接！");
	
	}else{
		%>
		如果你能访问，这个页面就能够下载到文件。
		<%
	}
	%>
</body>
</html>