<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商家注册页面</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body background="${ctp}/images/login8.jpg">
<header class="container" id="firstTitleArea">
    <div class="row">
        <div><h2>河南大学餐厅服务系统</h2></div>
    </div>
</header>
<div>
    <div class="col-md-6 col-md-offset-3" id="Main">
        <h3 align="center">欢迎商家注册</h3>
        <form:form class="form-horizontal" action="${ctp}/business/register" method="post"
                   modelAttribute="errBusiness">
            <div class="form-group">
                <label for="reName" class="col-sm-2 control-label">餐厅名</label>
                <div class="col-sm-10">
                    <form:select path="rid" cssClass="form-control" id="reName"
                                 items="${sessionScope.restaurants}"
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
                <label for="BuName" class="col-sm-2 control-label"><h6><b>负责人姓名</b></h6></label>
                <div class="col-sm-10">
                    <form:input type="text" class="form-control" id="BuName" path="name"
                                placeholder="请输入你的真实姓名"/>
                        ${errorInfo.name}
                </div>
            </div>
            <div class="form-group">
                <label for="BuTel" class="col-sm-2 control-label"><h6><b>负责人电话</b></h6></label>
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
                <div class="col-md-10 col-md-offset-1">
                    <input type="submit" class="btn btn-primary" role="button" style="width:90%" value="注册"/>
                </div>
            </div>
        </form:form>
        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span>&times;</span></button>
            <strong>${bus_register_msg}</strong>
        </div>
    </div>
</div>

</body>
</html>