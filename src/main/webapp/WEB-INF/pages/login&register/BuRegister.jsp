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
    <div class="col-md-6" style="margin-top: 60px">
        <img border="0" width="500" height="335" src="${ctp}/images/henu.jpg" alt="图片无法显示"/>
    </div>
    <div class="col-md-6">
        <h2 class="text-center">欢迎商家注册</h2>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">
                    商家个人信息
                    <span class="glyphicon glyphicon-pushpin pull-right" aria-hidden="true"></span>
                </h3>
            </div>
            <div class="panel-body">
                <form:form class="form-horizontal" action="${ctp}/business/register" method="post"
                           modelAttribute="errBusiness">
                    <div class="form-group">
                        <label for="reName" class="col-sm-2 control-label">餐厅名</label>
                        <div class="col-sm-10">
                            <form:select path="rid" cssClass="form-control" id="reName"
                                         items="${requestScope.restaurants}"
                                         itemLabel="name"
                                         itemValue="id"/>
                                ${errorInfo.rid}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="wdName" class="col-sm-2 control-label">窗口名</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" id="wdName" path="wname"
                                        placeholder="请输入店铺的窗口名称"/>
                                ${errorInfo.wname}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="WdNum" class="col-sm-2 control-label">窗口号</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="WdNum" name="wid">
                                ${errorInfo.wid}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuName" class="col-sm-2 control-label">负责人姓名</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" id="BuName" path="name"
                                        placeholder="请输入你的真实姓名"/>
                                ${errorInfo.name}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuTel" class="col-sm-2 control-label">负责人电话号码</label>
                        <div class="col-sm-10">
                            <form:input type="tel" class="form-control" id="BuTel" path="tel"
                                        placeholder="电话号码"/>
                                ${errorInfo.tel}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuPwd1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="BuPwd1" name="password" placeholder="请输入密码">
                                ${errorInfo.password}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuPwd2" class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="BuPwd2" name="password2"
                                   placeholder="请再次确认密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-10 col-md-offset-2">
                            <input type="submit" value="注册">
                        </div>
                    </div>
                </form:form>

                <!-- 出错显示的信息框 -->
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">
                        <span>&times;</span></button>
                    <strong>${bus_register_msg}</strong>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>