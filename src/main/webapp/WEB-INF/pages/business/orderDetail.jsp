<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<br><br>
<div class="container">
    <c:if test="${buDetails != null}">
        <table class="table table-hover">
            <thead>
            <tr>
                <td>${buDetails[0].product.business.wname}</td>
                <th>商品</th>
                <th>名称</th>
                <th>价格</th>
                <th>购买数量</th>
                <th>优惠券</th>
                <th>小计</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${buDetails}" var="detail">
                <tr style="text-align:center">
                    <td></td>
                    <td style="width: 20%;height: 20%">
                        <img alt="暂无法显示" style="width: 50%" src="${ctp}/${detail.product.photosrc}">
                    </td>
                    <td>${detail.product.productName}</td>
                    <td>${detail.product.productPrice}</td>
                    <td>${detail.num}</td>
                    <td>-${detail.discount}</td>
                    <td>${detail.product.productPrice * detail.num - detail.discount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>合计：${buOrder.total}</p>
    </c:if>
    <c:if test="${buDetails == null}">
        <p>订单查询出现错误</p>
    </c:if>
</div>
</body>
</html>