<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>餐品选购</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctp}/css/myStyle1.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
            <a class="navbar-brand" href="${ctp}/home">首页</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${ctp}/home">选择餐品</a></li>
                <li><a href="${ctp}/shopCart">购物车</a></li>
                <li><a href="${ctp}/PCenter">个人中心</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- 轮播图 -->
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="${ctp}/images/banner_1.jpg" alt="First slide">
            <div class="carousel-caption">北苑餐厅....</div>
        </div>
        <div class="item">

            <img src="${ctp}/images/banner_2.jpg" alt="Second slide">
            <div class="carousel-caption">南苑餐厅...</div>
        </div>
        <div class="item">
            <img src="${ctp}/images/banner_3.jpg" alt="Third slide">
            <div class="carousel-caption">教苑餐厅...</div>
        </div>
        <div class="item">
            <img src="${ctp}/images/banner_2.jpg" alt="Forth slide">
            <div class="carousel-caption">东苑餐厅...</div>
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br>
<!-- 搜索 -->
<div class="container">
    <div class="input-group">
        <input type="text" class="form-control input-lg"
               placeholder="餐厅名/餐品关键字...">
        <span class="input-group-addon btn btn-primary">搜索</span>
    </div>
</div>
<!-- 中部的餐品显示 -->
<div class="middle container">
    <ul>
        <c:forEach items="${products}" var="product">
            <li id="proinfo" class="col-md-offset-1 col-md-10 product">
                <a href="${ctp}/details?id=${product.bsId}&name=${product.productName}">
                    <div class="col-md-4">
                        <img alt="无法显示" src="${ctp}/${product.photosrc}"
                             class="col-md-3 img-rounded img-responsive">
                    </div>
                    <div class="col-md-6">
                        <h5>店铺号：${product.bsId}</h5>
                        <p style="color: red">评分：${product.productGrade}</p>
                        <p>商品名字:${product.productName}</p>
                        <p style="color: red">¥：${product.productPrice}</p>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
<!-- 友情链接 -->
<div class="container quick_link">
    <div class="row col-md-offset-1 col-md-10">
        <div class="col-md-4">
            <p>快速链接</p>
        </div>
        <div class="col-md-6">
            <ul>
                <li><a href="">河南大学官网</a></li>
                <li><a href="">教务系统</a></li>
                <li><a href="">英语学习</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- 底部 -->
<div class="container bottomdiv">
    <p class="btmp">
        XXX 版权所有 Copyright ©2020
        <a href="https://beian.miit.gov.cn/#/Integrated/index">豫ICP备xxxxxxxx号xx</a>
        豫公网安备 xxxxxxxxxxxxxx号
        javaweb小组制作维护
    </p>
</div>

</body>
</html>