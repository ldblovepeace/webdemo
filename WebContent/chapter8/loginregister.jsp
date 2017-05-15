<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function login(){
		form.action="mylogin.action";
		form.submit();
	}
	function register(){
		form.action="myregister.action";
		form.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<s:form name="form" action="loginregister">
		<s:textfield name="username" label="用户名111"></s:textfield>
		<s:textfield name="password" label="密码"></s:textfield>
		<s:submit value="登陆" onclick="login()"></s:submit>
		<s:submit value="注册" onclick="register()"></s:submit>
	</s:form>
</body>
</html>