<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="${ctp}/js/jquery.cookie.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            var verifyCodeImg = document.getElementsByClassName("verifyCodeImg");
            $.each(verifyCodeImg, function (index, item) {
                item.src = "${ctp}/login/checkCode?time=" + new Date().getTime();
            })
        }

        //设置Cookie
        function setCookie(){
            var username = $('#username').val();
            var password = $('#password').val();
            var ischecked = $("input[type='checkbox']").is(":checked");//获取是否选中
            if(ischecked==true){//如果选中-->记住密码登录
                $.cookie("username",username.trim(),7);//有效时间7天，
                $.cookie("password",password.trim(),7);
                alert("记住了密码")
            }else{//如果没选中-->不记住密码登录
                $.cookie("password", "");
                $.cookie("username", "");
                alert("没有记住密码")
            }
        }

        //获取cookie
        function getCookie(){ //获取cookie
            var username = $.cookie("username"); //获取cookie中的用户名
            var pwd =  $.cookie("password"); //获取cookie中的登陆密码
            if(pwd){//密码存在的话把“记住用户名和密码”复选框勾选住
                $("[name='rememenber']").attr("checked","true");
            }
            if(username!=""){//用户名存在的话把用户名填充到用户名文本框
                $("#username").val(username);
            }else{
                $("#username").val("");
            }
            if(pwd!=""){//密码存在的话把密码填充到密码文本框
                $("#password").val(pwd);
            }else{
                $("#password").val("");
            }
        }
        // 异步登录方法
        function loginAjax(url, data, nextUrl) {
            var ischecked = $("input[type='checkbox']").is(":checked");//获取选中状态

            $.ajax({
                url: url,
                contentType: "application/json;charset=utf-8",
                data: data,
                type: "post",
                dataType: "json",
                success:
                    function (data) {
                        /*if(ischecked==true){
                            setCookie();   //调用设置Cookie的方法
                            location.href = nextUrl
                        }else if(ischecked==false){
                            setCookie();  //调用设置Cookie的方法
                            location.href = url
                        }*/

                        if (data.flag == 1) {
                            location.href = nextUrl
                        } else if (data.flag == -1) {
                            // 刷新验证码
                            refreshCode();
                            $("#LoginInfo").html(data.login_msg);
                        }
                    },
                error:
                    function () {
                        alert("出错了...")
                    }
            })
        }

        // 消费者登录异步方法
        function stLoginAjax() {
            $("#stLoginForm").submit(function () {
                var url = "${ctp}/consumer/login"
                var data = JSON.stringify($(this).serialize())
                var nextUrl = $("#stLoginForm").attr("action")
                loginAjax(url, data, nextUrl)
                return false;
            })
        }

        // 商家异步登录方法
        function buLoginAjax() {
            $("#bsLoginForm").submit(function () {
                var url = "${ctp}/business/login"
                var data = JSON.stringify($(this).serialize())
                var nextUrl = $("#bsLoginForm").attr("action")
                loginAjax(url, data, nextUrl)
                return false;
            })
        }

        // 管理员异步登录方法
        function admLoginAjax() {
            $("#admLoginForm").submit(function () {
                var url = "${ctp}/admin/login"
                var data = JSON.stringify($(this).serialize())
                var nextUrl = $("#admLoginForm").attr("action")
                loginAjax(url, data, nextUrl)
                return false;
            })
        }
        $(function () {
            stLoginAjax()
            buLoginAjax()
            admLoginAjax()
        })
    </script>
</head>
<body background="${ctp}/images/login8.jpg">
<header class="container" id="firstTitleArea">
    <div class="row col-md-12">
        <div class="col-md-10 "><h2>河南大学餐厅服务系统</h2></div>
    </div>
</header>
<div class="container">
    <div class="container col-md-6" id="mainArea">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#StLogin" class="changeTab" data-toggle="tab" onclick="refreshCode()">
                师生登录</a></li>
            <li><a href="#BuLogin" class="changeTab" data-toggle="tab" onclick="refreshCode()">商家登录</a></li>
            <li><a href="#AcLogin" class="changeTab" data-toggle="tab">管理员登录</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="StLogin">
                <br>
                <c:if test="${history == null}">
                <form id="stLoginForm" action="${ctp}/home" method="post">
                    </c:if>
                    <c:if test="${history != null}">
                    <form id="stLoginForm" action="${history}" method="post">
                        </c:if>
                        <div class="form-group">
                            <label for="InputStNum">账号</label>
                            <input type="text" class="form-control" id="InputStNum" name="username"
                                   value="1812030001" placeholder="请输入学号/教职工号">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <label for="InputStPwd">密码</label>
                            <input type="password" class="form-control" id="InputStPwd" name="password"
                                   value="12345" placeholder="请输入密码">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-inline">
                            <label for="verifyCode1">验证码：</label>
                            <input type="text" name="verifyCode" class="form-control" id="verifyCode1"
                                   value="1111" placeholder="请输入验证码"
                                   style="width: 120px;"/>
                            <a href="javascript:refreshCode()">
                                <img src="${ctp}/login/checkCode" class="verifyCodeImg" alt="点击刷新"/>
                            </a>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 记住密码
                            </label>
                        </div>
                        <div class="form-group">
                            <a class="btn btn-success col-md-4 pull-left" href="${ctp}/register/consumer"
                               role="button">注册</a>
                            <input class="btn btn-success col-md-4 pull-right" type="submit" value="登录">
                        </div>
                        <br>
                    </form>
            </div>
            <div class="tab-pane fade" id="BuLogin">
                <br>
                <form id="bsLoginForm" action="${ctp}/business/home" method="post">
                    <div class="form-group">
                        <label for="username">用户名：</label>
                        <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
                    </div>
                    <div class="form-group">
                        <label for="password">密码：</label>
                        <input type="password" name="password" class="form-control" id="password"
                               placeholder="请输入密码"/>
                    </div>
                    <div class="form-inline">
                        <label for="verifyCode2">验证码：</label>
                        <input type="text" name="verifyCode" class="form-control" id="verifyCode2"
                               placeholder="请输入验证码"
                               style="width: 120px;"/>
                        <a href="javascript:refreshCode()">
                            <img src="${ctp}/login/checkCode" class="verifyCodeImg" alt="点击刷新"/>
                        </a>
                    </div>
                    <div class="checkbox">
                        <label> <input type="checkbox"> 记住密码
                        </label>
                    </div>
                    <div class="form-group" style="text-align: center;">
                        <a class="btn btn-success col-md-4 pull-left" href="${ctp}/register/business"
                           role="button">注册</a>
                        <input class="btn btn btn-success col-md-4 pull-right" type="submit" value="登录">
                    </div>
                </form>
                <br>
            </div>
            <div class="tab-pane fade" id="AcLogin">
                <br>
                <form id="admLoginForm" action="${ctp}/admin/home" method="post">
                    <div class="form-group">
                        <label for="InputAcNum">账号</label>
                        <input type="text" class="form-control" name="username" value="admin" id="InputAcNum"
                               placeholder="请输入管理员账号">
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <label for="InputAcPwd">密码</label>
                        <input type="password" class="form-control" name="password" value="admin" id="InputAcPwd"
                               placeholder="请输入密码">
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
                <br>
            </div>
        </div>
        <br>
        <br>
        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span></button>
            <strong id="LoginInfo">${login_info}</strong>
        </div>
    </div>
</div>
</body>
</html>