<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存储对象</title>
</head>
<body>
<%=request.getAttribute("flag")%>
<%
	session.setAttribute("flag", "好好学习");

%>
<%=request.getAttribute("flag")%>
<%=session.getAttribute("flag")%>
<%
	session.setAttribute("flag", "好好休息");

%>
<%=session.getAttribute("flag")%>
<hr/>
<%
	//session.removeAttribute("flag");

	application.setAttribute("flag", "按时吃饭!");

%>
<%=application.getAttribute("flag")%>
</body>
</html>