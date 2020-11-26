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
<header class="container" id="firstTitleArea">
    <div class="row">
        <div class="col-md-10">
            <h1>河南大学餐厅服务系统</h1>
        </div>
    </div>
</header>

<div class="row">
    <div class="col-md-8 col-md-offset-3" style="margin-top: 70px">
        <a class="btn btn-primary mybtn" href="${ctp}/login/consumer" role="button">学生入口</a>
    </div>
    <div class="col-md-8 col-md-offset-3">
        <a class="btn btn-success mybtn" href="${ctp}/login/business" role="button">商家入口</a>
    </div>
    <div class="col-md-8 col-md-offset-3">
        <a class="btn btn-info mybtn" href="${ctp}/login/admin" role="button">管理员入口</a>
    </div>
</div>
</body>
</html>