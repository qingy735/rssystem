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

    <script>
        function addCondition() {

        }
    </script>

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
                <li><a href="${ctp}/PCenter?username=${sessionScope.conLoginInfo.username}">个人中心</a></li>
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
            <img src="${ctp}/images/food.jpg" alt="First slide">
            <div class="carousel-caption">北苑餐厅....</div>
        </div>
        <div class="item">

            <img src="${ctp}/images/food2.jpg" alt="Second slide">
            <div class="carousel-caption">南苑餐厅...</div>
        </div>
        <div class="item">
            <img src="${ctp}/images/hotpot1.jpg" alt="Third slide">
            <div class="carousel-caption">教苑餐厅...</div>
        </div>
        <div class="item">
            <img src="${ctp}/images/food3.jpg" alt="Forth slide">
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
    <form id="selectForm" class="form-inline" method="post" action="${ctp}/home">
        <div class="form-group">
            <label for="name">菜品名</label>
            <input type="text" class="form-control" id="name" name="name" value="${sessionScope.conds.name}">
        </div>
        <div class="form-group">
            <label for="price">最低价钱</label>
            <input type="text" class="form-control" id="price" name="price" value="${sessionScope.conds.price}">
        </div>
        <div class="form-group">
            <label for="grade">评分高于</label>
            <input type="text" class="form-control" id="grade" name="grade" value="${sessionScope.conds.grade}">
        </div>
        <input type="submit" class="btn btn-default" value="搜索"/>
    </form>
</div>
<!-- 中部的餐品显示 -->
<div class="middle container">
    <ul>
        <c:forEach items="${pb.list}" var="product">
            <li id="proinfo" class="col-md-offset-1 col-md-10 product">
                <a href="${ctp}/details?id=${product.business.username}&name=${product.productName}">
                    <div class="col-md-4">
                        <img alt="无法显示" src="${ctp}/${product.photosrc}"
                             class="col-md-3 img-rounded img-responsive">
                    </div>
                    <div class="col-md-6">
                        <h5>店铺号：${product.business.username}</h5>
                        <p style="color: red">评分：${product.productGrade}</p>
                        <p>商品名字:${product.productName}</p>
                        <p style="color: red">¥：${product.productPrice}</p>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
<!-- 分页条 -->
<nav aria-label="Page navigation">
    <ul class="pagination">
        <c:choose>
            <c:when test="${sessionScope.pb.currentPage == 1}">
                <li class="disabled">
                    <a href="javascript:void(0)"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="${ctp}/home?p=${sessionScope.pb.currentPage - 1}" onclick="addCondition();"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:otherwise>
        </c:choose>

        <c:forEach begin="1" end="${sessionScope.pb.totalPage}" var="i">
            <c:if test="${sessionScope.pb.currentPage == i}">
                <li class="active">
                    <a href="${ctp}/home?p=${i}" onclick="addCondition();">${i}</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.pb.currentPage != i}">
                <li>
                    <a href="${ctp}/home?p=${i}" onclick="addCondition();">${i}</a>
                </li>
            </c:if>
        </c:forEach>

        <c:choose>
            <c:when test="${sessionScope.pb.currentPage == sessionScope.pb.totalPage}">
                <li class="disabled">
                    <a href="javascript:void(0)"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="${ctp}/home?p=${sessionScope.pb.currentPage + 1}" onclick="addCondition();"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:otherwise>
        </c:choose>

        <span style="font-size: 25px;margin-left: 5px">
            共${sessionScope.pb.totalCount}条记录，共${sessionScope.pb.totalPage}页
        </span>
    </ul>
</nav>
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