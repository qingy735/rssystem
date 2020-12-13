<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员界面</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
<body>
<div class="page">
    <div style="height: 100%;width: 15%;" class="pull-left">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${ctp}/business/home">商家后台</a>
                </div>
                <br><br>
                <div>
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active"><a href="${ctp}/admin" target="mainFrame">个人中心</a></li>
                        <li><a href="${ctp}/admin" target="mainFrame">消费者</a></li>
                        <li><a href="${ctp}/admin" target="mainFrame">商家</a></li>
                        <li><a href="${ctp}/admin" target="mainFrame">订单</a></li>
                        <li><a href="${ctp}/admin" target="mainFrame">评价</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div style="height: 100%;width: 85%;" class="pull-left">
        <div style="height: 15%;width: 100%">
            <header class="container" id="TopArea">
                <div class="row">
                    <div class="col-md-10"><h2>河南大学餐厅服务系统</h2></div>
                    <div class="col-md-2"><a href="${ctp}/business/logout"><h4>退出登录</h4></a></div>
                </div>
            </header>
        </div>
        <div style="height: 85%;width: 100% ;border: solid">
            <iframe name="mainFrame" src="${ctp}/admin" frameborder="no"></iframe>
        </div>
    </div>
</div>
</body>
</html>
