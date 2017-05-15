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
			请输入用户注册信息
		</div>
		单击此处<a href="login.jsp">login</a>
		<font color="red"><s:actionerror/></font>
		<s:form action="register" namespace="/chapter16">
			<s:textfield label="用户名" name="username"/>
			<s:password label="密码" name="password"/>
			<s:password label="请再次输入密码" name="repassword" required="true"></s:password>
			<s:textfield label="email" name="email" value=""></s:textfield>
			<s:textfield label="手机号" name="phonenum"></s:textfield>
			<s:combobox name="system" label="系统" list="{'冷轧MES','热轧MES','炼钢投料'}"></s:combobox>
			<s:textfield label="验证码" name="validationCode"/>
			验证码：<img id="img_validation_code" src="validation_code.action" onClick="this.src = 'validation_code.action?' + Math.random()"/>
			<s:submit value="注册"></s:submit>
		</s:form>
	</center>
	
	<script type="text/javascript">
		<s:if test="result!=null">alert('<s:property value="result" escape="false"/>');</s:if>
	</script>
	
</body>
</html>