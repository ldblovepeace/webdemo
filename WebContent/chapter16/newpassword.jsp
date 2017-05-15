<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<%
		String username=request.getParameter("username");
		String system=request.getParameter("system");
	%>
	<div style="margin-top: 20px;margin-left:20px;font-size:20px;height:50px">
			请设置用户<%=username %>在<%=system %>系统的新密码
	</div>
	<form action="newpassword.action">
	<table>
	<tr>
		<td>
		用户名：
		</td>
		<td>
		<input type="text" name="username" id="username" readonly = "readonly" value = "<%=username %>">
		</td>
	</tr>
	<tr>
		<td>
		系统：
		</td>
		<td>
		<input type="text" name="system" id="system" readonly = "readonly" value = "<%=system %>">
		</td>
	</tr>
	<tr>
		<td>
		新密码：
		</td>
		<td>
		<input type="text" name="newpassword" id="newpassword">
		</td>
	</tr>
	<tr>
		<td>
		重复密码：
		</td>
		<td>
		 <input type="text" name="repassword" id="repassword">
		</td>
	</tr>
	<%
		
	%>
	<tr>
		<td align="center">
		<input type="submit" value="确定" onclick="CheckRepassword()">
		</td>
	</tr>
	</table>
	
	</form>
</center>
</body>
<script type="text/javascript">
	function CheckRepassword(){
		var newpassword = document.getElementById("newpassword");
		var repassword = document.getElementById("repassword");
		if(repassword.value != newpassword.value){
			alert("两次输入的密码必须一致!");
			repassword.focus();
			return;
		}
	}
</script>
</html>