<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bootstrap + servlet</title>
<meta name="viewport" content="width = device-width, initial-scale=1,height = device-height">
<!-- bootstrap基于jquery 首先导入jquery开发包 -->
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<!-- 本次编写需要基于表单，考虑到数据验证的问题，可以不写row样式 -->
		<form action="Test.jsp" id="loginForm" method="post" class="form-horizontal">
			<fieldset>
				<legend class="row-md-1">
					<label>
						<span class="glyphicon glyphicon-user">&nbsp;用户登陆
						</span>
					</label>
				</legend>
				<!-- 描述mid输入信息的内容 -->
				<div class="form-group" id="midDiv" align="center">
					<label class="col-md-3 control-lable"for="mid">&nbsp;用户名：</label>
					<div class="col-md-6">
						<input type="text" id="mid" class="form-control" placeholder="请输入用户名">
					</div>
					<div class="col-md-3" id="midSpan"></div>
				</div>
				
				<div class="form-group" id="passwordDiv" align="center">
					<label class="col-md-3 control-lable"for="password">&nbsp;密码：</label>
					<div class="col-md-6">
						<input type="text" id="password" class="form-control" placeholder="请输入密码">
					</div>
					<div class="col-md-3" id="passwordSpan"></div>
				</div>
				
				<div class="form-group" id="ButtonDiv" align="center">
					<div class="col-md-5">
						<button type="submit" id="subBut" class="btn btn-xs-btn-primary" align="right">登陆</button>
					</div>
					<div class="col-md-5" align="left">
						<button type="reset" id="rstBut" class="btn btn-xs-btn-warning">重置</button>
					</div>
				</div>
			</fieldset>
		</form>
		
	</div>
</body>
</html>