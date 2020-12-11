<%--
  Created by IntelliJ IDEA.
  User: Qing_Y
  Date: 2020-12-11
  Time: 10:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 导航栏 -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${ctp}/home">首页</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav" id="u_nav">
                <li id="l_home"><a href="${ctp}/home">选择餐品</a></li>
                <li id="l_shopCart"><a href="${ctp}/shopCart">购物车</a></li>
                <li id="l_pastOrder"><a href="${ctp}/pastOrder">历史订单</a></li>
                <li id="l_assessment"><a href="${ctp}/assessment">我的评价</a></li>
                <li id="l_discount"><a href="${ctp}/discount">优惠券</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        个人资料 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctp}/alterInfo/alterNickname">修改昵称</a></li>
                        <li><a href="${ctp}/alterInfo/alterPassword">修改密码</a></li>
                        <li><a href="${ctp}/PInfo">个人信息</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.conLoginInfo != null}">
                    <li><a href="${ctp}/consumer/logout">退出登录</a></li>
                </c:if>
                <c:if test="${sessionScope.conLoginInfo == null}">
                    <li><a href="${ctp}/login/consumer">登录</a></li>
                    <li><a href="${ctp}/register/consumer">注册</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<br><br><br>
