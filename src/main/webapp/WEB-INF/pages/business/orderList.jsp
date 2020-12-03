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
	<div id="TitleArea">店铺订单列表</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="table table-hover" align="center">
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>消费者</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="orderListData">
				<%
					for (int i = 0; i <= 4; i++) {
				%>
				<tr height="60" align="center">
					<td>15375222</td>
					<td>小明</td>
					<td>2014-12-08 23:29:18.0</td>
					<td>204.0</td>
					<td>未结账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><a href="${ctp}/orderDetail">详细</a> <a
						href="#">结账</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>