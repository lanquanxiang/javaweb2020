<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP语法</title>
</head>
<body>
<h1>html代码</h1>
<!-- html注释 -->
<% int x=1; //当前页面的临时变量%>
<%! int y=1; //全局变量 %>
<%-- jsp的注释 --%>
<%
	x=x+1;
	y=y+1;
	//System.out.print(x);
	out.print("x="+x);
%>
<br/>
x=<%out.print(x); %><br/>
y=<%=y %>
</body>
</html>