<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商家后台登录首页面</title>
    <link rel="stylesheet" type="text/css"
          href="../bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="../bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="../bootstrap-3.3.7-dist/css/index.css"/>
</head>
<body>
<header class="container" id="firstTitleArea">
    <div class="row">
        <div class="col-md-10">
            <h1>河南大学餐厅服务系统</h1>
        </div>
    </div>
</header>

<div class="row">
    <div class="col-md-8 col-md-offset-3" style="margin-top: 70px">
        <a class="btn btn-primary mybtn" href="StLogin.jsp" role="button">学生入口</a>
    </div>
    <div class="col-md-8 col-md-offset-3">
        <a class="btn btn-success mybtn" href="BuLogin.jsp" role="button">商家入口</a>
    </div>
    <div class="col-md-8 col-md-offset-3">
        <a class="btn btn-info mybtn" href="AcLogin.jsp" role="button">管理员入口</a>
    </div>
</div>

<script src="../bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>