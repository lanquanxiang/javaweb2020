<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	//.....
	if(username==null || username.equals("")){
		session.setAttribute("error", "用户名不合法!");
		response.sendRedirect("error.jsp");
		return;
	}
	//年龄的判断
	
	// 爱好的判断
	
	
	//读取登记表，做用户名重复的判断
	
	//更新登记表
	
	response.sendRedirect("show.jsp");

%>
</body>
</html>