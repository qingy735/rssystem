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
<div class="container">
    <form class="row row-centered">
        <div class="well col-md-6 col-centered">
            <ul id="myTab" class="nav nav-tabs">
                <li class="active"><a href="#StLogin" data-toggle="tab">
                    师生登录</a></li>
                <li><a href="#BuLogin" data-toggle="tab">商家登录</a></li>
                <li><a href="#AcLogin" data-toggle="tab">管理员登录</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="StLogin">
                    <form id="loginForm" action="${ctp}/home" method="post">
                        <div class="form-group">
                            <label for="InputStNum">账号</label>
                            <input type="text" class="form-control" id="InputStNum" name="username" placeholder="请输入学号/教职工号">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <label for="InputStPwd">密码</label>
                            <input type="password" class="form-control" id="InputStPwd" name="password" placeholder="请输入密码">
                            <span class="help-block"></span>
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
                            <label>
                                <input type="checkbox"> 记住密码
                            </label>
                        </div>
                        <div class="form-group">
                            <a class="btn btn-success col-md-4 pull-left" href="${ctp}/register/consumer" role="button">注册</a>
                            <input class="btn btn-success col-md-4 pull-right" type="submit" value="登录">
                        </div>
                        <br>
                        <br>
                    </form>
                    <!-- 出错显示的信息框 -->
                    <div class="alert alert-warning alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert">
                            <span>&times;</span></button>
                        <strong id="conLoginInfo">${bus_login_msg}</strong>
                    </div>
                </div>
                <div class="tab-pane fade" id="BuLogin">
                    <form action="${ctp}/business/home" method="post" id="loginForm">
                        <div class="form-group">
                            <label for="username">用户名：</label>
                            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
                        </div>
                        <div class="form-group">
                            <label for="password">密码：</label>
                            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
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
                        <div class="form-group" style="text-align: center;">
                            <input class="btn btn btn-success col-md-4 pull-left" type="button" id="registerBtn" value="注册">
                            <input class="btn btn btn-success col-md-4 pull-right" type="submit" value="登录">
                        </div>
                        <br>
                        <br>
                    </form>
                    <!-- 出错显示的信息框 -->
                    <div class="alert alert-warning alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert">
                            <span>&times;</span></button>
                        <strong id="busLoginInfo">${bus_login_msg}</strong>
                    </div>
                </div>
            <div class="tab-pane fade" id="AcLogin">
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
                        <input class="btn btn btn-success col-md-10 col-md-offset-1" type="submit" value="登录">
                    </div>
                </form>
            </div>
            </div>
        </div>
    </form>
</div>
<!--
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
-->
</body>
</html>