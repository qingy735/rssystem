<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>个人中心</title>
</head>
<body>
<!-- 导航栏 -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand active" href="${ctp}/PCenter">个人中心</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="${ctp}/home">选择餐品</a></li>
                <li><a href="${ctp}/shopCart">购物车</a></li>
                <li><a href="${ctp}/pastOrder">历史订单</a></li>

                <li><a href="${ctp}/assessment">我的评价</a></li>
                <li><a href="${ctp}/discount">优惠券</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        个人资料 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctp}/alterInfo/alterNickname">修改昵称</a></li>
                        <li><a href="${ctp}/alterInfo/alterPassword">修改密码</a></li>
                        <li><a href="${ctp}/PInfo">个人信息</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctp}/consumer/logout">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<hr>
<c:forEach items="${orders}" var="order">
    ${order}<br>
</c:forEach>

</body>

</html>