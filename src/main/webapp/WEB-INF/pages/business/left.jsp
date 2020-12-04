<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
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
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">商家后台</a>
        </div>
        <div>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="${ctp}/Buinfo" target="mainFrame">个人中心</a></li>
                <li><a href="${ctp}/orderList" target="mainFrame">订单列表</a></li>
                <li><a href="${ctp}/productList" target="mainFrame">餐品列表</a></li>
                <li><a href="${ctp}/uploadProducts" target="mainFrame">上传餐品</a></li>
                <li><a href="${ctp}/message" target="mainFrame">消息列表</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
