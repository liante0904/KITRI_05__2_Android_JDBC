<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">

function Update() {
	

	document.frmUpd.submit();
	
	
}

function Cancel() {
	
}

</script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="top.jsp" %>


	<form action="<%=vUrl %>/MemController.do" method="post" name="frmUpd">
<input type="hidden" name="category" value="frmUpd">

<table border='1'>
<tr><td colspan="2">
<div style="text-align:center"> ** Update **</div></td></tr>
<tr><th>name</th><td><input type="text" name="mem_name"></td></tr>
<tr><th>ID</th><td><input type="text" name="mem_id">
<tr><th>PASSWD</th><td><input type="password" name="mem_pwd"></td></tr>
<tr><th>Email</th><td><input type="text" name="mem_email">
<tr><th>Phone</th><td><input type="text" name="mem_phone"></td></tr>
<tr><th>Address</th><td><input type="text" name="mem_addr">

</td></tr>
<tr><td colspan="2">
<div style="text-align:center">
<input type="button" value="Update" onclick="Update()">
<input type="button" value="Cancel" onclick="Cancel()">
</div></td></tr>
</table>
</form>

<%@ include file="bottom.jsp" %>


</body>
</html>


