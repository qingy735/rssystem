<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>师生注册页面</title>
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
		<div class="col-md-8" style="margin-top: 60px">
			<img border="0" width="800" height="435"
				src="../oFile/images/henu.jpg" />
		</div>
		<div class="col-md-4">
			<h2 class="text-center">欢迎师生注册</h2>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						师生个人信息 <span class="glyphicon glyphicon-pushpin pull-right"
							aria-hidden="true"></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="StName" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="StName"
									placeholder="请输入你的真实姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="stNum" class="col-sm-2 control-label">账号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="stNum"
									placeholder="请输入你的学号/教职工号">
							</div>
						</div>
						<div class="form-group">
							<label for="nickname" class="col-sm-2 control-label">昵称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="nickname"
									placeholder="给自己取个昵称吧">
							</div>
						</div>
						<div class="form-group">
							<label for="StTel" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="tel" class="form-control" id="StTel"
									placeholder="电话号码">
							</div>
						</div>
						<div class="form-group">
							<label for="Stpwd1" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="Stpwd1"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label for="Stpwd2" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="Stpwd2"
									placeholder="请再次确认密码">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2 control-label">性别</div>
							<div class="col-sm-4">
								<div class="radio">
									<label> <input type="radio" name="optionsRadios"
										id="optionsRadios1" value="option1" checked>男
									</label> <label> <input type="radio" name="optionsRadios"
										id="optionsRadios2" value="option2"> 女
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
						  <div class="col-md-10 col-md-offset-2">
						  <a class="btn btn-primary" href="#" role="button" style="width:90%">注册</a>
						  </div>
							</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="../bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
	<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>