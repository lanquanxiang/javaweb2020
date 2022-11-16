<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车信息</title>
</head>
<body style="text-align: center;">
<jsp:include page="head.jsp"/>
<c:if test="${empty list }">
	<h2>还没有任何信息!</h2>
</c:if>
<c:if test="${not empty list}">
	<table style="margin: auto;">
		<tr>
			<th>序号</th>
			<th>id</th>
			<th>name</th>
			<th>type</th>
			<th>price</th>
		</tr>
		<c:forEach items="${list }" var="x" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${x.car_id}</td>
				<td>${x.car_name}</td>	
				<td>${x.car_type}</td>
				<td>${x.car_price}</td>					
			</tr>
		</c:forEach>
	</table>
</c:if>
<br/>
</body>
</html>