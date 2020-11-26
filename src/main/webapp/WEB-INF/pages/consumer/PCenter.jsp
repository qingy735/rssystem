<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
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
<header class="container">
    <div class="row">
        <div class="col-md-10"><h1>河南大学餐厅服务系统</h1></div>
        <div class="col-md-2"><a href=""><h1>退出登录</h1></a></div>
    </div>
</header>
<!-- 导航栏 -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
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
        </div>
    </div>
</nav>
</body>

</html>