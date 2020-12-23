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
    <script>
        function c(e,obj) {
            for (var i = 1; i < 6; i++) {
                if (e == i) {
                    document.getElementById('li' + i).className = 'active';
                } else {
                    document.getElementById('li' + i).className = '';
                }
            }
        }
    </script>
</head>
<body>
<div class="page">
    <div style="height: 100%;width: 15%;" class="pull-left">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${ctp}/admin/home">管理员后台</a>
                </div>
                <br><br>
                <div>
                    <ul class="nav nav-pills nav-stacked" id="nav_home">
                        <li class="active" id="li1" onclick="c(1,this)"><a href="${ctp}/admin/consumers" target="mainFrame">消费者管理</a></li>
                        <li class="" id="li2" onclick="c(2,this)"><a href="${ctp}/admin/businesses" target="mainFrame">商家管理</a></li>
                        <li class="" id="li3" onclick="c(3,this)"><a href="${ctp}/admin/orders" target="mainFrame">订单管理</a></li>
                        <li class="" id="li4" onclick="c(4,this)"><a href="${ctp}/admin/comments" target="mainFrame">评价管理</a></li>
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
                    <div class="col-md-2"><a href="${ctp}/admin/logout"><h4>退出登录</h4></a></div>
                </div>
            </header>
        </div>
        <div style="height: 85%;width: 100% ;border: solid">
            <iframe name="mainFrame" src="${ctp}/admin/consumers" frameborder="no"></iframe>
        </div>
    </div>
</div>
</body>
</html>
