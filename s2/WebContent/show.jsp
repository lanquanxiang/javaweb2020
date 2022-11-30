<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<table>
		<tr>
			<th>序号</th>
			<th>id</th>
			<th>name</th>
			<th>type</th>
			<th>price</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="x" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${x.car_id}</td>
				<td>${x.car_name}</td>	
				<td>${x.car_type}</td>
				<td>
					<fmt:formatNumber value="${x.car_price}" pattern=".00" type="number"></fmt:formatNumber>
				</td>	
				<td>
					<a href="edit?car_id=${x.car_id}&car_name=${x.car_name}"><button>编辑</button></a>
					<button>删除</button>
				</td>					
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="6">${bar}</td>
		</tr>
	</table>
</c:if>
<br/>
</body>
</html>