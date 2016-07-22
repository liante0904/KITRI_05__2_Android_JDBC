<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<% 
	String vUrl = request.getContextPath();
	out.print(vUrl);
%>
</head>
<body>

	<a href="<%=vUrl %>/indexT.jsp"> Home</a>
	<a href="<%=vUrl %>/memLogin.jsp"> Login</a>
	<a href="<%=vUrl %>/memInsert.jsp"> Join</a>
	<a href="<%=vUrl %>/memUpdate.jsp"> Update</a>
	<a href="<%=vUrl %>/memDelete.jsp"> Delete</a>
	<a href="<%=vUrl %>?category=frmList"> List</a>


</body>
</html>