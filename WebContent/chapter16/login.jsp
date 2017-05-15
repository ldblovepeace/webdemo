<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<div style="margin-top: 20px;margin-left:20px;font-size:20px;height:50px">
			请输入用户名密码
		</div>
		如果您还没注册，请单击此处<a href="register.jsp">注册</a>
		<font color="red"><s:actionerror/></font>
		<s:form action="login" namespace="/chapter16">
			<s:textfield label="用户名" name="username"/>
			<s:password label="密码" name="password"/>
			<s:textfield label="验证码" name="validationCode"/>
			验证码：<img id="img_validation_code" src="validation_code.action" onClick="this.src = 'validation_code.action?' + Math.random()"/>
			<a href="forgetpassword.jsp">忘记密码</a><s:submit value="登陆"></s:submit>
		</s:form>
	</center>
</body>
	<script type="text/javascript">
		<s:if test="result!=null">alert('<s:property value="result" escape="false"/>');</s:if>
	</script>
</html>