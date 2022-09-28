<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息显示</title>
</head>
<body>
<h1>你输入的信息是：</h1>
<%
	request.setCharacterEncoding("utf-8");
%>
姓名：<%=request.getParameter("username") %><br/>
标签：<%--=request.getParameterValues("tag") --%><br/>
<%
String[] tags = request.getParameterValues("tag");
if(tags!=null){
	for(int i=0;i<tags.length;i++){
		out.print(tags[i]+" ");
	}
}

%>
<%=Arrays.toString(tags) %>
</body>
</html>