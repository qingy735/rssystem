<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>历史订单</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/myStyle1.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>

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
                            <a href="#ofModal" data-toggle="modal">去结账</a>
                            <!-- 弹出框 -->
                            <div class="modal fade" id="ofModal" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content" style="margin-top: 30%;background-color: snow;">
                                        <form action="${ctp}/order/update?id=${order.id}&status=1" method="post">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close"><span aria-hidden="true">&times;</span>
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel"
                                                    style="color: #2e6da4;text-align: center">支付页面</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-md-8 col-md-offset-2">
                                                        <label>备注：</label>
                                                        <textarea cols="20" rows="4" class="form-control" id="note"
                                                                  name="note"></textarea>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <label class="col-md-6 pull-left">支付宝支付&nbsp;<input type="radio"
                                                                                                        name="zf"></label>
                                                    <label class="col-md-6 pull-left">微信支付&nbsp;<input type="radio"
                                                                                                       name="zf"></label>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="submit" class="del btn" value="支付"/>
                                                <a href="" class="del btn">取消支付</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
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