<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车信息</title>
<style type="text/css">
	.bar a{
		padding: 10px;
		text-decoration: none;
	}
</style>
<script type="text/javascript">
	function updateNum() {
		window.location.href="showcar?page=1&num="+ document.querySelector("input[name='num']").value;
	}

</script>
</head>
<body style="text-align: center;">
<jsp:include page="head.jsp"/>
<h1>汽车信息表</h1>
<c:if test="${empty list}">
	<h2>还没有任何信息！</h2>
</c:if>
<c:if test="${not empty list}">
	<table style="margin: auto;">
		<tr>
			<th>序号</th>
			<th>id</th>
			<th>name</th>
			<th>type</th>
			<th>price</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="carinfo" varStatus="x">
			<tr>
				<td>${x.count}</td>
				<td>${carinfo.car_id}</td>
				<td>${carinfo.car_name}</td>
				<td>${carinfo.car_type}</td>
				<td>
					<fmt:formatNumber type="number" value="${carinfo.car_price}" pattern=".00"></fmt:formatNumber>
				</td>
				<td>
					<a href="edit.jsp?index=${x.index}"><button>编辑</button></a>
					<form action="delete" style="display: inline-block;">
						<input type="hidden" name="carid" value="${carinfo.car_id}"/>
 						<button>删除</button>
					</form>
				</td>
			</tr>		
		</c:forEach>
		
		<tr class="bar">
			<td colspan="6">${bar}</td>
		</tr>
		<tr>
			<td colspan="6">
				每页显示<input type="number" name="num" value="${num}"/>条<button onclick="updateNum()">确定</button> 
			</td>
		</tr>
	</table>
</c:if>
</body>
</html>