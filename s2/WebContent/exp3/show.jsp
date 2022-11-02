<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户信息</title>
</head>
<body>
<h1>用户登记表</h1>
<c:if test="${empty list }">
	<h2>还没有任何登记信息!</h2>
</c:if>
<c:if test="${not empty list}">
	<table>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>爱好</th>
		</tr>
		<c:forEach items="${list }" var="x" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${x.username}</td>
				<td>${x.age}</td>
				<td>
					<c:forEach items="${x.hobby }" var="h">${h}</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br/>
<a href="#">返回主页继续登记</a>
</body>
</html>