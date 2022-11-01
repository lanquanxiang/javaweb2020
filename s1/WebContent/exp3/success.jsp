<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登记成功</title>
</head>
<body>
<h1>你登记的信息是：</h1>
姓名：${sessionScope.user.username}
年龄：${user.age}
爱好：<c:forEach items="${user.hobby}" var="x">${x}</c:forEach>
</body>
</html>