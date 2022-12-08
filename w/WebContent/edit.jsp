<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑</title>
</head>
<jsp:include page="head.jsp"/>
<body style="text-align: center;">
	<h1>信息编辑</h1>
	<form action="#" method="post">
		<table style="margin: auto;">
			<tr>
				<td>汽车ID</td>
				<td><input type="text"  value="${list[param.index].car_id}" disabled="disabled"/>
					<input type="hidden" name="car_id" value="${list[param.index].car_id}" />
				</td>
			</tr>
			<tr>
				<td>汽车Name</td>
				<td><input type="text" name="car_name" value="${list[param.index].car_name}"/></td>
			</tr>
			<tr>
				<td>汽车Type</td>
				<td><input type="text" name="car_type" value="${list[param.index].car_type}"/></td>
			</tr>
			<tr>
				<td>汽车Price</td>
				<td><input type="text" name="car_price" 			
				
				value="<fmt:formatNumber type='number' value='${list[param.index].car_price}' pattern='.00'></fmt:formatNumber>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登录"/></td>
			</tr>
		</table>	
	</form>
</body>
</html>