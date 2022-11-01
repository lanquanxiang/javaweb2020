<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<h1>用户信息</h1>
<c:if test="${empty list}">
	<h2>还没有任何信息！</h2>
</c:if>
<c:if test="${not empty list}">
	<table>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>密码</th>
		</tr>
		<c:forEach items="${list }" var="user" varStatus="x">
			<tr>
				<td>${x.count }</td>
				<td>${user.name}</td>
				<td>${user.password}</td>
			</tr>		
		</c:forEach>	
	</table>
</c:if>
</body>
</html>