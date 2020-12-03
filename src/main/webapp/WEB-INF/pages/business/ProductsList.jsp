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
	<div id="TitleArea">菜品列表</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="#" method="get">
			<input type="hidden" name="method" value="search"> <input
				type="text" name="keyword" title="请输入菜品名称"> <input
				type="submit" value="搜索">
		</form>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<table class="table table-hover" align="center">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>餐品编号</td>
					<td>餐品名称</td>
					<td>价格</td>
					<td>餐品类型</td>
					<td>图片</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<%
					for (int i = 1; i <= 12; i++) {
				%>
				<tr height="60" align="center">
					<td><%=i%>&nbsp;</td>
					<td>土豆丝&nbsp;</td>
					<td>7.0&nbsp;</td>
					<td>菜&nbsp;</td>
					<td><img border="0" width="20" height="20"
						src="../oFile/images/baizhuoxia.jpg" />&nbsp;</td>
					<td><a href="updateFood.html" class="FunctionButton">更新</a> <a
						href="/wirelessplatform/food.html?method=delete&id=1"
						onClick="return delConfirm();" class="FunctionButton">删除</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<div id="TableTail" align="center">
			<div class="btn">
				<a href="updateProducts.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>