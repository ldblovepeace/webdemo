<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function checkRegister(){
	var username= document.getElementById("username");
	if(username.value == ""){
		alert("用户名必须输入!");
		username.focus();
		return;
	}
	var password = document.getElementById("password");
	if(password.value == ""){
		alert("密码必须输入!");
		password.focus();
		return;
	}
	var repassword = document.getElementById("repassword");
	if(repassword.value != password.value){
		alert("两次输入的密码必须一致!");
		repassword.focus();
		return;
	}
	var email = document.getElemetnById("email");
	if (email.value != null){
		if(!checkEmail(email)) return;
	}
	var validation_code = document.getElementById("validation_code");
	if(validation_code.value == ""){
		alert("验证码必须输入!");
		validation_code.foucus();
		return;
	}
	
	register_form.submit();
}

function checkEmail(email){
	var email = email.value;
	var pattern = /^([a-zA-z0-9._-])+@([a-zA-z0-9_-]+(\.[a-zA-z0-9_-])+/;
	flag = pattern.test(mail);
	if(!flag){
		alert("email格式不正确！");
		email.focus();
		return false;
	}
	return true;
}
function refresh(){
	var img = document.getElementById("img_validation_code");
	img.src = 'ValidationCode?' + Math.random();
}
</script>
<title>Insert title here</title>
</head>
<body>
 <form name="register_form" action="register111" method="post">
 	<span class="require">*用户名：</span>
 	<input type="text" id="username" name="username" size="30" maxLength="30"><br>
 	<span class="reuqire">*密码：</span>
 	<input type="text" id="password" name="password" size="30" maxLength="30"><br>
 	<span class="reuqire">*请再次输入密码：</span>	
 	<input type="text" id="repassword" name="repassword" size="30" maxLength="30"><br>
 	<span class="reuqire">*邮箱地址：</span>
 	<input type="text" id="email" name="email" size="30" maxLength="30"><br>
 	<span class="reuqire">*验证码：</span>
 	<input type="text" id="validation_code" name="validation_code" style="width:60px;margin-top:2px"  size="30" maxLength="30">
 	<img id="img_validation_code" src="ValidationCode" onclick = "this.src = 'ValidationCode?' + Math.random()"/>
 	<input type="button" value="刷新" onclick="refresh()"/><br>
 	<input type="submit" value="注册" onclick="checkRegister()"/>
 </form>
</body>
</html>