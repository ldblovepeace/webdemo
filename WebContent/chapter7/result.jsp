<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>书名</td>
			<td>价格</td>
		</tr>
		<s:iterator value="result">
		<tr>
			<td><s:property value="key"/></td>
			<td><s:property value="value"/></td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>