<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP构成</title>
</head>
<body>
	<%
		System.out.print("hello!");
		out.print("hello");
		for(int i=0;i<10;i++){
			
		}
		int x = 1;
		//java注释
		
		/*Java多行注释*/
	%>
	x+1=<%=x+1 %>
	
	
	<!--  HTML注释  -->
	<%-- JSP注释 --%>
	
</body>
</html>