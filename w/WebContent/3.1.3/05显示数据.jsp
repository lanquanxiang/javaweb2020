<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示数据</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");	

	String username = request.getParameter("username");
	String[] tags = request.getParameterValues("tag");
	response.getWriter().print("姓名："+username+"<br/>");
	response.getWriter().print("标签：");
	if(tags==null){
		response.getWriter().print("你什么都没有选!");
	}else{
		for(int i=0;i<tags.length;i++){
			response.getWriter().print(tags[i]);
		}
	}
	

%>
<%=Arrays.toString(tags) %>
</body>
</html>