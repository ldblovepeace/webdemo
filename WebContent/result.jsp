<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${requestScope.page }" method = "post" id="myForm"></form>

${requestScope.page}

<script type="text/javascript">
	alert('${requestScope.info}');
	setTimeout(load(),2000);
	function load(){
		document.getElementById("myForm").submit();
	}
</script>
</body>
</html>