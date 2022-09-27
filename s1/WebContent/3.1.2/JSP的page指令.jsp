<%@page import="java.util.Date"%>
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
//language 取值只有java  表示当前使用java语言编写的
//contentType 上下文类型，表示了浏览器显示方式和编码text/html  MIME 文本
//pageEncoding 页面编码方式
//import导入其他的类和库
// isErrorPage 是否是处理错误的页面 取值：true、false
// ErrorPage 处理错误的页面在哪里？ 取值：URL
// A存在错误  A说：B是给我处理错误的   ErrorPage="B"
// B承认自己是处理错误  isErrorPage="true"  false(不能接收Exception信息)
%>
<%=new Date().toString() %>
</body>
</html>