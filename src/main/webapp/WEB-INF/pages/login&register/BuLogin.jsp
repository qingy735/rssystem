<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商家登录页面</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        function refreshCode() {
            var verifyCodeImg = document.getElementById("verifyCodeImg");
            verifyCodeImg.src = "${ctp}/login/checkCode?time=" + new Date().getTime();
        }

        $(function () {
            $("#registerBtn").click(function () {
                location.href = "${ctp}/register/business";
            })
        })
    </script>

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
        <img border="1" width="800" height="435"
             src="${ctp}/images/henu.jpg"/>
    </div>
    <div class="col-md-4 logindiv" style="margin-top: 60px">
        <h2 class="text-center">欢迎商家登录</h2>
        <form action="${ctp}/business/login" method="post">
            <div class="form-group">
                <label for="username">用户名：</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"
                       value="10001"/>
            </div>
            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"
                       value="12345"/>
            </div>
            <div class="form-inline">
                <label for="verifyCode">验证码：</label>
                <input type="text" name="verifyCode" class="form-control" id="verifyCode" placeholder="请输入验证码"
                       style="width: 120px;"/>
                <a href="javascript:refreshCode()">
                    <img src="${ctp}/login/checkCode" id="verifyCodeImg" alt="点击刷新"/>
                </a>
            </div>
            <div class="checkbox">
                <label> <input type="checkbox"> 记住密码
                </label>
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="button" id="registerBtn" value="注册">
                <input class="btn btn btn-primary" type="submit" value="登录">
            </div>
        </form>

        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span></button>
            <strong>${login_msg}</strong>
        </div>
    </div>
</div>
</body>
</html>