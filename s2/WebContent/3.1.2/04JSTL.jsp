<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
<%! int x = 0;%>
<% x = x+1; 
	session.setAttribute("x", x);

%>
<c:if test="${x<10}">
	0<%=x %>
</c:if>

</body>
</html>