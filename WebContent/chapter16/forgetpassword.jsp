<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码找回</title>
</head>
<body>
	<center>
		<div style="margin-top: 20px;margin-left:20px;font-size:20px;height:50px">
			密码找回
		</div>
		如果您还没注册，请单击此处<a href="register.jsp">注册</a>
		<p>根据所属用户名对应手机号发送短信验证码</p>
		<font color="red"><s:actionerror/></font>
		<s:form action="forgetpassword" namespace="/chapter16">
			<s:textfield label="用户名" name="username"/>
			<s:combobox name="system" label="系统" list="{'冷轧MES','热轧MES','炼钢投料'}"></s:combobox>
			<s:textfield label="图片验证码" name="validationCode"/>
			<s:textfield label="短信验证码" name="textcode"></s:textfield>
			验证码：<img id="img_validation_code" src="validation_code.action" onClick="this.src = 'validation_code.action?' + Math.random()"/>
			
			<input type="button" onclick="sendtext()" value="发送验证码">
			
			<s:submit value="确认" ></s:submit>
			
		</s:form>

		<script type="text/javascript">
		<s:if test="result!=null">
			alert('<s:property value="result" escape="false"/>');
		</s:if>
		function sendtext(){
			document.forgetpassword.action="sendtext.action";
			document.forgetpassword.submit();
		}
	</script>
	</center>
</body>
	
</html>