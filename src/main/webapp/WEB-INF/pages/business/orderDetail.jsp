<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单详细说明</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea" class="navbar-fixed-top">订单详细说明</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <br><br>
    <table class="table table-bordered Dtabel" align="center">
        <thead>
        <tr id="TableTitle">
            <td>订单ID</td>
            <td>备注</td>
            <td>取餐码</td>
            <td>下单时间</td>
            <td>状态</td>
            <td>是否使用折扣</td>
            <td>消费者学号</td>
            <td>消费者姓名</td>
            <td>消费者昵称</td>
            <td>消费者电话号码</td>
            <td>商品id</td>
            <td>商品名字</td>
            <td>商品单价</td>
            <td>商品数量</td>
        </tr>
        </thead>
        <tbody id="orderDetailData">
        <tr align="center">
            <td>${order.orderId}</td>
            <td>${order.note}</td>
            <td>${order.code}</td>
            <td>${order.orderTime}</td>
            <td>${order.status}</td>
            <td>${order.discountUse}</td>
            <td>${order.consumer.username}</td>
            <td>${order.consumer.name}</td>
            <td>${order.consumer.nickname}</td>
            <td>${order.consumer.tel}</td>
            <td>${order.product.id}</td>
            <td>${order.product.productName}</td>
            <td>${order.product.productPrice}</td>
            <td>${order.num}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>