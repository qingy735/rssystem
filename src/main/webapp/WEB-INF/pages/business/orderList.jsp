<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单列表</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body>
<div id="TitleArea" class="navbar-fixed-top">订单列表</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <br><br>
    <table class="table table-hover" align="center">
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>订单编号</td>
            <td>消费者id</td>
            <td>取餐码</td>
            <td>下单日期</td>
            <td>备注</td>
            <td>总金额</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="orderListData">
        <c:forEach items="${sessionScope.busOrders}" var="order">
            <tr height="60" align="center">
                <td>${order.id}</td>
                <td>${order.cid}</td>
                <td>${order.code}</td>
                <td>${order.orderTime}</td>
                <td>${order.note}</td>
                <td>${order.total}</td>
                <td>${order.status == 1 ? "已结账" : "未结账"}</td>
                <td><a href="${ctp}/business/orderDetail?oid=${order.id}" target="mainFrame">查看详情</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>