<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div id="TopMainArea">
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
        <c:forEach items="${sessionScope.orders}" var="order">
            <tr height="60" align="center">
                <td>${order.orderId}</td>
                <td>${order.consumer.name}</td>
                <td>${order.orderTime}</td>
                <td>${order.totalPrice}</td>
                <td>${order.status == 0 ? "未结账":"已结账"}</td>
                <td>
                    <a href="${ctp}/orderDetail?oid=${order.orderId}">详细</a>
                    <a href="#">结账</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>