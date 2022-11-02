<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<c:if test="${empty list }">
	<h2>还没有任何信息!</h2>
</c:if>
<c:if test="${not empty list}">
	<table>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>密码</th>
		</tr>
		<c:forEach items="${list }" var="x" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${x.name}</td>
				<td>${x.password}</td>				
			</tr>
		</c:forEach>
	</table>
</c:if>
<br/>
</body>
</html>