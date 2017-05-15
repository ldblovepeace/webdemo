<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Login" method="post" name="loginForm">
	<span>
		用户名：<input type="text" id="username" value ="${requestScope.username }" name="username" size="30" maxLength="30">
		<font color="red"> ${requestScope.usernameError }</font>
		<br>
	</span>
	<span>
		密码   ：<input type="text" id="password"  name="password" size="30" maxLength="30">
		<font color = "red"> ${requestScope.passwordError }</font>
		<br>
	</span>
	<span>
		验证码：<input type="text" id="validation_code" name="validation_code" style="width:60px;margin-top:2px"  size="30" maxLength="30">
		<img id="img_validation_code" src="validation_code.action" onclick = "this.src = 'validation_code.action?' + Math.random()"/>
		<font color="red"> ${requestScope.codeError }</font>
		<br>
	</span>
	<input type="submit" value="登陆" name="login">
	<input type="submit" value="注册" name="register">
</form>
</body>
</html>