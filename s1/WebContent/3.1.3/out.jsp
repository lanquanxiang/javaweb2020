<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接收参数并输出</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String username = request.getParameter("username");
	String[] tags = request.getParameterValues("tag");
	
	


%>
<h2>你提交的信息是：</h2><br>
姓名：<%=username %><br>
标签：<%=Arrays.toString(tags) %>
<%
if(tags!=null){
	for(int i=0;i<tags.length;i++){
		out.print(tags[i]);
	}
}else{
	out.print("你没有选择标签！");
}

%>
</body>
</html>