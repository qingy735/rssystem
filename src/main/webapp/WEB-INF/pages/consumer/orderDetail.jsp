<%--
  Created by IntelliJ IDEA.
  User: Qing_Y
  Date: 2020-12-15
  Time: 16:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<h3>订单详情</h3>
<c:if test="${details != null}">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <td>${details[0].product.business.wname}</td>
                <th>商品</th>
                <th>名称</th>
                <th>价格</th>
                <th>购买数量</th>
                <th>优惠券</th>
                <th>小计</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${details}" var="detail">
                <tr style="text-align:center">
                    <td></td>
                    <td style="width: 20%;height: 20%">
                        <a href="${ctp}/details?pid=${detail.pid}"><!--跳转商品详情-->
                            <img alt="暂无法显示" style="width: 50%" src="${ctp}/${detail.product.photosrc}">
                        </a>
                    </td>
                    <td>${detail.product.productName}</td>
                    <td>${detail.product.productPrice}</td>
                    <td>${detail.num}</td>
                    <td>-${detail.discount}</td>
                    <td>${detail.product.productPrice * detail.num - detail.discount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>合计：${order.total}</p>
    </div>
</c:if>
<c:if test="${details == null}">
    <p>订单查询出现错误</p>
</c:if>
</body>
</html>
