<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
汽车的id:<input type="text" name="id" value="${list[param.index].car_id }"/><br/>
汽车的name:${list[param.index].car_name }<br/>
汽车的type:${list[param.index].car_type }<br/>
汽车的price:${list[param.index].car_price }<br/>
</body>
</html>