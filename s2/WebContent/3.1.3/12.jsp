<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>访问次数</title>
</head>
<body>
<%
	int n = 0;
	int m = 0;
	try{
		n=(int)session.getAttribute("num");
	}catch(Exception e){
		n=0;
	}
	try{
		m=(int)application.getAttribute("num");
	}catch(Exception e){
		m=0;
	}
	n=n+1;
	m=m+1;
	session.setAttribute("num", n);
	application.setAttribute("num", m);


%>
你访问了网站<%=session.getAttribute("num") %>次。<br/>
网站被访问了<%=application.getAttribute("num") %>次。<br/>
</body>
</html>