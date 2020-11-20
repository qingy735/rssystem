<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员登录页面</title>
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
    <div class="col-md-8 " style="margin-top: 60px">
        <img border="0" width="800" height="435"
             src="${ctp}/images/henu.jpg"/>
    </div>
    <div class="col-md-4 " class="logindiv"
         style="margin-top: 60px">
        <h2 class="text-center">欢迎管理员登录</h2>
        <form>
            <div class="form-group">
                <label for="InputAcNum">账号</label>
                <input type="text" class="form-control" id="InputAcNum" placeholder="请输入管理员账号">
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label for="InputAcPwd">密码</label>
                <input type="password" class="form-control" id="InputAcPwd" placeholder="请输入密码">
                <span class="help-block"></span>
            </div>
            <div class="checkbox">
                <label> <input type="checkbox"> 记住密码
                </label>
            </div>
            <div class="form-group">
                <a class="btn btn-success col-md-10 col-md-offset-1" href="#"
                   role="button">登录</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>