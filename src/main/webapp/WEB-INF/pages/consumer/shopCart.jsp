<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctp}/css/myStyle1.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>购物车</title>
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
            <a class="navbar-brand" href="${ctp}/shopCart">购物车</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="${ctp}/home">选择餐品</a></li>
                <li><a href="${ctp}/PCenter">个人中心</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- 加购的餐品列表 -->
<!-- 通过数据库调用显示 -->
<%
    for (int i = 0; i < 5; i++) {
%>
<div class="container">
    <div class="row">

    </div>
</div>
<%
    }
%>
<div style="width: 100%;text-align: center;">
<img style="align-content: center;width: 20%;" class="notfound" src="${ctp}/images/nofound.png" >
<span>您还没有加购任何商品，快去选购吧~</span>
</div>
<br><br>
<div class="row countPrice col-md-10 col-md-offset-1">
    <div class="countPrice1 " style="float: left">
        <input type="checkbox">&nbsp;全选&nbsp;
    </div>
    <div class="countPrice1" style="float: left">
        <a >删除&nbsp;</a>
    </div>
    <div class="countPrice1 form-inline" style="float: left">
                <label class="form-inline">已选择商品&nbsp;0&nbsp;件</label>
    </div>
    <div style="float: right">
        <button type="button" class="btn btn-warning" >结&nbsp;算</button>
    </div>
    <div class="countPrice1" style="float: right">
        <span style="color: red"> &nbsp;10.00&nbsp;&nbsp;</span>
    </div>
    <div class="countPrice1" style="float: right">
        <span>总金额：</span>
    </div>


</div>
</body>
</html>