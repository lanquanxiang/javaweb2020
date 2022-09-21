<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP变量</title>
</head>
<body>
<%int x = 1;%>
<%!int y=1;%>
<% 
x=x+1;
y=y+1;
%>
运行结果如下:<br/>
x=<%=x %><br/>
y=<%=y %><br/>


<%
	//out.print("x="+x);

%>
</body>
</html>