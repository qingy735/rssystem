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

    <title>历史订单</title>
</head>
<body>
<!-- 导航栏 -->
<jsp:include page="head.jsp"/>
<br>
<div style="width: 100%;text-align: center;">
    <c:if test="${sessionScope.conOrders != null}">
        <table class="table table-hover" align="center">
            <thead>
            <tr align="center" valign="middle" id="TableTitle">
                <td>订单编号</td>
                <td>取餐码</td>
                <td>下单日期</td>
                <td>商家id</td>
                <td>备注</td>
                <td>总额</td>
                <td>状态</td>
                <td>&nbsp;&nbsp;</td>
            </tr>
            </thead>
            <c:forEach items="${sessionScope.conOrders.list}" var="order">
                <!--显示数据列表 -->
                <tbody id="orderListData">
                <tr height="60" align="center">
                    <td>${order.id}</td>
                    <td>${order.code}</td>
                    <td>${order.orderTime}</td>
                    <td>${order.bid}</td>
                    <td>${order.note}</td>
                    <td>${order.total}</td>
                    <c:if test="${order.status == 0}">
                        <td>
                            未结账
                            <br>
                            <a href="${ctp}/order/update?oid=${order.id}&status=1">去结账</a>
                        </td>
                    </c:if>
                    <c:if test="${order.status == 1}">
                        <td>已结账</td>
                    </c:if>
                    <td><a href="${ctp}/pastOrder/detail?oid=${order.id}">查看详情</a></td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${sessionScope.conOrders == null}">
        <img style="align-content: center;width: 40%;" class="notfound" src="${ctp}/images/noorder.png">
    </c:if>

    <!-- 分页条 -->
    <div class="middle container divPage">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${sessionScope.conOrders.currentPage == 1}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/pastOrder?p=${sessionScope.conOrders.currentPage - 1}" class="skipBtn"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <c:forEach begin="1" end="${sessionScope.conOrders.totalPage}" var="i">
                    <c:if test="${sessionScope.conOrders.currentPage == i}">
                        <li class="active">
                            <a href="${ctp}/pastOrder?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.conOrders.currentPage != i}">
                        <li>
                            <a href="${ctp}/pastOrder?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:choose>
                    <c:when test="${sessionScope.conOrders.currentPage == sessionScope.conOrders.totalPage}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/pastOrder?p=${sessionScope.conOrders.currentPage + 1}" class="skipBtn"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <span style="font-size: 25px;margin-left: 5px">
            共${sessionScope.conOrders.totalCount}条记录，共${sessionScope.conOrders.totalPage}页
        </span>
            </ul>
        </nav>
    </div>

    <button value="">去加购</button>
    <button value="">去付款</button>
</div>
</body>
</html>