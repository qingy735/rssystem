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
<!-- 页面标题 -->
<div id="TitleArea">订单详细说明</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <h4>订单ID：${order.orderId}</h4>
    <h4>备注：${order.note}</h4>
    <h4>取餐码：${order.code}</h4>
    <h4>下单时间：${order.orderTime}</h4>
    <h4>状态：${order.status}</h4>
    <h4>是否使用折扣：${order.discountUse}</h4>
    <h4>消费者学号：${order.consumer.username}</h4>
    <h4>消费者姓名：${order.consumer.name}</h4>
    <h4>消费者昵称：${order.consumer.nickname}</h4>
    <h4>消费者电话：${order.consumer.tel}</h4>
    <h4>商品id：${order.product.id}</h4>
    <h4>商品名字：${order.product.productName}</h4>
    <h4>商品单价：${order.product.productPrice}</h4>
    <h4>商品数量：${order.num}</h4>
</div>
</body>
</html>