<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $(".checkout").click(function () {
                var oid = $(this).attr("oid")
                alert(oid)
                return false;
            })
        })
    </script>

    <title>历史订单</title>
</head>
<body>
<header class="container">
    <div class="row">
        <div class="col-md-10"><h1>河南大学餐厅服务系统</h1></div>
        <div class="col-md-2"><a href="${ctp}/consumer/logout"><h1>退出登录</h1></a></div>
    </div>
</header>
<!-- 导航栏 -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand active" href="${ctp}/PCenter">返回个人中心</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="${ctp}/assessment">我的评价</a></li>
                <li><a href="${ctp}/discount">优惠券</a></li>
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
        </div>
    </div>
</nav>
<div style="width: 100%;text-align: center;">
    <c:if test="${sessionScope.conOrders != null}">
        <table class="table table-hover" align="center">
            <thead>
            <tr align="center" valign="middle" id="TableTitle">
                <td>订单编号</td>
                <td>取餐码</td>
                <td>下单日期</td>
                <td>商品名称</td>
                <td>单价</td>
                <td>份数</td>
                <td>总金额</td>
                <td>餐厅名称</td>
                <td>窗口名称</td>
                <td>状态</td>
            </tr>
            </thead>
            <!--显示数据列表 -->
            <tbody id="orderListData">
            <c:forEach items="${sessionScope.conOrders}" var="order">
                <tr height="60" align="center">
                    <td>${order.orderId}</td>
                    <td>${order.code}</td>
                    <td>${order.orderTime}</td>
                    <c:choose>
                        <c:when test="${order.status == -1}">
                            <td>无</td>
                            <td>无</td>
                            <td>无</td>
                            <td>无</td>
                            <td>无</td>
                            <td>无</td>
                            <td>商品已下架</td>
                        </c:when>
                        <c:when test="${order.status != -1}">
                            <td>${order.product.productName}</td>
                            <td>${order.product.productPrice}</td>
                            <td>${order.num}</td>
                            <td>${order.totalPrice}</td>
                            <td>${order.business.rname}</td>
                            <td>${order.business.wname}</td>
                            <td>
                                <c:if test="${order.status == 0}">
                                    未结账<br>
                                    <a oid="${order.orderId}" class='checkout'>去结账</a>
                                </c:if>
                                <c:if test="${order.status == 1}">
                                    已结账
                                </c:if>
                            </td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${sessionScope.conOrders == null}">
        <img style="align-content: center;width: 40%;" class="notfound" src="${ctp}/images/noorder.png">
    </c:if>
    <button value="">去加购</button>
    <button value="">去付款</button>
</div>
</body>
</html>