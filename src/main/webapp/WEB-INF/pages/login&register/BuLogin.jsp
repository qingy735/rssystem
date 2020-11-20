<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商家登录页面</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
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
    <div class="col-md-1"></div>
    <div class="col-md-6" style="margin-top: 60px">
        <img border="0" width="800" height="435"
             src="${ctp}/images/henu.jpg"/>
    </div>
    <div class="col-md-4 logindiv"
         style="margin-top: 60px">
        <h2 class="text-center">欢迎商家登录</h2>
        <form>
            <div class="form-group">
                <label for="InputBuNum">账号</label> <input type="text"
                                                          class="form-control" id="InputBuNum" placeholder="请输入商家已注册账号">
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label for="InputBuPwd">密码</label> <input type="password"
                                                          class="form-control" id="InputBuPwd" placeholder="请输入密码">
                <span class="help-block"></span>
            </div>
            <div class="checkbox">
                <label> <input type="checkbox"> 记住密码
                </label>
            </div>
            <div class="form-group">
                <a class="btn btn-success col-md-4 pull-left" href="BuRegister.jsp"
                   role="button">注册</a>
                <a class="btn btn-success col-md-4 pull-right" href="${ctp}/business/logincheck"
                   role="button">登录</a>
            </div>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>

<script src="${ctp}/js/jquery-3.3.1.min.js"></script>
<script src="${ctp}/js/bootstrap.min.js"></script>
</body>
</html>