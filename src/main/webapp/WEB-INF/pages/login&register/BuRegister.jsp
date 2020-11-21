<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <form class="form-horizontal" action="${ctp}/business/register" method="post">
                    <div class="form-group">
                        <label for="reName" class="col-sm-2 control-label">餐厅名</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="reName" name="rid">
                                <c:forEach items="${requestScope.restaurants}" var="restaurant">
                                    <option value="${restaurant.id}">${restaurant.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="wdName" class="col-sm-2 control-label">窗口名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="wdName"
                                   placeholder="请输入店铺的窗口名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="WdNum" class="col-sm-2 control-label">窗口号</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="WdNum">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuName" class="col-sm-2 control-label">负责人姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="BuName"
                                   placeholder="请输入你的真实姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuTel" class="col-sm-2 control-label">负责人电话号码</label>
                        <div class="col-sm-10">
                            <input type="tel" class="form-control" id="BuTel"
                                   placeholder="电话号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuPwd1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="BuPwd1"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="BuPwd2" class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="BuPwd2"
                                   placeholder="请再次确认密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-10 col-md-offset-2">
                            <a class="btn btn-primary" href="${ctp}/business/register" role="button"
                               style="width: 90%">注册</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>