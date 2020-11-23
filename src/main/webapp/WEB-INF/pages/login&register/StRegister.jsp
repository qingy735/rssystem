<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>师生注册页面</title>
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
    <div class="col-md-8" style="margin-top: 60px">
        <img border="0" width="800" height="435" src="${ctp}/images/henu.jpg"/>
    </div>
    <div class="col-md-4">
        <h2 class="text-center">欢迎师生注册</h2>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">
                    师生个人信息
                    <span class="glyphicon glyphicon-pushpin pull-right" aria-hidden="true"></span>
                </h3>
            </div>
            <div class="panel-body">
                <form:form cssClass="form-horizontal" action="${ctp}/consumer/register" method="post"
                           modelAttribute="errConsumer">
                    <div class="form-group">
                        <label for="StName" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <form:input type="text" path="name" id="StName" cssClass="form-control"
                                        placeholder="请输入你的姓名"/>
                                ${errorInfo.name}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stNum" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="stNum" name="username"
                                   placeholder="请输入你的学号/教职工号"/>
                                ${errorInfo.username}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nickname" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" id="nickname" path="nickname"
                                        placeholder="给自己取个昵称吧"/>
                                ${errorInfo.nickname}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="StTel" class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" id="StTel" path="tel" placeholder="电话号码"/>
                                ${errorInfo.tel}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="Stpwd1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" id="Stpwd1" placeholder="请输入密码">
                                ${errorInfo.password}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="Stpwd2" class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password2" id="Stpwd2"
                                   placeholder="请再次确认密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2 control-label">性别</div>
                        <div class="col-sm-4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="sex" value="1" checked="true"/>男
                                </label>
                                <label>
                                    <form:radiobutton path="sex" value="0"/>女
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-10 col-md-offset-2">
                            <input type="submit" class="btn btn-primary" role="button" style="width:90%" value="注册"/>
                        </div>
                    </div>
                </form:form>
                <!-- 出错显示的信息框 -->
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">
                        <span>&times;</span></button>
                    <strong>${con_register_msg}</strong>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>