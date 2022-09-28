<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户输入数据</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/OutServlet" method="post">
	姓名:<input type="text" name="username"/><br/>
	标签：<input type="checkbox" value="高" name="tag">高
	<input type="checkbox" value="富" name="tag">富
	<input type="checkbox" value="帅" name="tag">帅
	<input type="submit" value="提交">
</form>
</body>
</html>