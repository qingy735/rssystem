<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>河南大学餐厅服务系统</title>
	<link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
	<script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3 class="text-muted">河南大学餐厅服务系统</h3>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="Buinfo.jsp">个人中心</a></li>
					<li><a href="orderList.jsp">订单列表</a></li>
					<li><a href="ProductsList.jsp">餐品列表</a></li>
					<li><a href="updateProducts.jsp">上传餐品</a></li>
					<li><a href="#">消息列表</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- 页面标题 -->
	<div id="TitleArea">更新新餐品</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						餐品信息信息 <span class="glyphicon glyphicon-pushpin pull-right"
							aria-hidden="true"></span>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">餐品名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="username">
							</div>
						</div>
						<div class="form-group">
							<label for="stNum" class="col-sm-2 control-label">餐品简介</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="stNum">
							</div>
						</div>
						<div class="form-group">
							<label for="nickname" class="col-sm-2 control-label">餐品价格</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="nickname">
							</div>
						</div>
						<div class="form-group">
							<label for="telephone" class="col-sm-2 control-label">图片</label>
							<div class="col-sm-10">
								<img
									style='max-width: 68px; width: 68px; width: expression(width &gt; 68 ? "68px" : width "px"); max-width: 68px;'
									src="style/images/baizhuoxia.jpg"> <input type="hidden"
									name="image" value="baizhuoxia.jpg"> <input type="file"
									name="imageUrl" /> *
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-10 col-md-offset-2">
								<input type="submit" value="修改" class="FunctionButtonInput">
								<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>