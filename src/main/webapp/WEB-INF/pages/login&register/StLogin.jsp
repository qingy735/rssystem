<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>师生登录页面</title>
<link rel="stylesheet" type="text/css"
	href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="../bootstrap-3.3.7-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../bootstrap-3.3.7-dist/css/index.css" />
</head>
<body>
<header class="container" id="firstTitleArea">
		<div class="row">
			<div class="col-md-10">
				<h1>河南大学餐厅服务系统</h1>
				</div>
			</div>
	</header>
<div class="row">
		<div class="col-md-8 " style="margin-top: 60px">
			<img border="0" width="800" height="435"
				src="../oFile/images/henu.jpg" />
		</div>
		<div class="col-md-4 " class="logindiv"
			style="margin-top: 60px">
			<h2 class="text-center">欢迎师生登录</h2>
			<form>
				<div class="form-group">
					<label for="InputStNum">账号</label> <input type="text"
						class="form-control" id="InputStNum" placeholder="请输入学号/教职工号">
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<label for="InputStPwd">密码</label> <input type="password"
						class="form-control" id="InputStPwd" placeholder="请输入密码">
					<span class="help-block"></span>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox"> 记住密码
					</label>
				</div>
				<div class="form-group">
					<a class="btn btn-success col-md-4 pull-left" href="StRegister.jsp"
						role="button">注册</a> <a
						class="btn btn-success col-md-4 pull-right" href="#"
						role="button">登录</a>
				</div>
			</form>
		</div>
	</div>
	

	<script src="../bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
	<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>