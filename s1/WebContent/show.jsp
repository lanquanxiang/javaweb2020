<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车信息</title>
</head>
<body style="text-align: center;">
<jsp:include page="head.jsp"/>
<h1>汽车信息</h1>
<c:if test="${empty list}">
	<h2>还没有任何信息！</h2>
</c:if>
<c:if test="${not empty list}">
	<table style="margin: auto;">
		<tr>
			<th>序号</th>
			<th>id</th>
			<th>名字</th>
			<th>类型</th>
			<th>价格</th>
		</tr>
		<c:forEach items="${list }" var="car" varStatus="x">
			<tr>
				<td>${x.count }</td>
				<td>${car.car_id}</td>
				<td>${car.car_name}</td>				
				<td>${car.car_type}</td>				
				<td>${car.car_price}</td>
			</tr>		
		</c:forEach>	
	</table>
</c:if>
</body>
</html>