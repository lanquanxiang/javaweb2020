<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out输出对象</title>
</head>
<body>
<%	out.print("1"); %><br/>
<%	response.getWriter().print("2"); %><br/>
</body>
</html>