<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">



<script type="text/javascript">

function Login() {
	

	document.frmLog.submit();
	
	
}

function Cancel() {
	
}

</script>


<title>Insert title here</title>
</head>
<body>
<%@ include file="top.jsp" %>



	<form action="<%=vUrl %>/MemController.do" method="post" name="frmLog">
<input type="hidden" name="category" value="frmLog">
<table border='1'>
<tr><td colspan="2">
<div style="text-align:center"> ** Login **</div></td></tr>
<tr><th>ID</th><td><input type="text" name="mem_id"></td></tr>
<tr><th>PASSWD</th><td><input type="password" name="mem_pwd"></td></tr>

<tr><td colspan="2">
<div style="text-align:center">
<input type="button" value="Login" onclick="Login()">
<input type="button" value="Cancel" onclick="Cancel()">
</div>
</td></tr>
</table>
</form>

<%@ include file="bottom.jsp" %>


</body>
</html>




