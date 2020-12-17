<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员界面</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $(".skipBtn").click(function () {
                // 改变表单action指向
                $("#selectForm").attr("action", this.href)
                // 提交表单
                $("#selectForm").submit();
                return false;
            })
        })
    </script>

</head>
<body>
<div id="TitleArea">订单管理</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <div class="container searchPdt">
        <form id="selectForm" class="form-inline" method="post" action="${ctp}/admin/orders">
            <div class="form-group">
                <label for="id">订单号</label>
                <input type="text" class="form-control" id="id" name="id" value="${sessionScope.ordConds.id}">
            </div>
            <div class="form-group">
                <label for="cid">用户id</label>
                <input type="text" class="form-control" id="cid" name="cid" value="${sessionScope.ordConds.cid}">
            </div>
            <div class="form-group">
                <label for="bid">商家id</label>
                <input type="text" class="form-control" id="bid" name="bid"
                       value="${sessionScope.ordConds.bid}">
            </div>
            <div class="form-group">
                <label for="status">订单状态(0/1)</label>
                <input type="text" class="form-control" id="status" name="status"
                       value="${sessionScope.ordConds.status}">
            </div>
            <input type="submit" class="btn btn-default" value="搜索"/>
        </form>
    </div>
    <table class="table table-hover" align="center">
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>订单编号</td>
            <td>消费者用户名</td>
            <td>下商家用户名</td>
            <td>备注</td>
            <td>取餐码</td>
            <td>状态</td>
            <td>订单日期</td>
            <td>总价</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="orderListData">
        <c:forEach items="${sessionScope.pageOrder.list}" var="order">
            <tr height="60" align="center">
                <td>${order.id}</td>
                <td>${order.cid}</td>
                <td>${order.bid}</td>
                <td>${order.note}</td>
                <td>${order.code}</td>
                <td>已结账</td>
                <td>${order.orderTime}</td>
                <td>${order.total}</td>
                <td>
                    <a onclick="return confirm('确定要删除吗？')" class="btn">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 分页条 -->
    <div class="middle container divPage">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${sessionScope.pageOrder.currentPage == 1}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/admin/orders?p=${sessionScope.pageOrder.currentPage - 1}" class="skipBtn"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <c:forEach begin="1" end="${sessionScope.pageOrder.totalPage}" var="i">
                    <c:if test="${sessionScope.pageOrder.currentPage == i}">
                        <li class="active">
                            <a href="${ctp}/admin/orders?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.pageOrder.currentPage != i}">
                        <li>
                            <a href="${ctp}/admin/orders?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:choose>
                    <c:when test="${sessionScope.pageOrder.currentPage == sessionScope.pageOrder.totalPage}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/admin/orders?p=${sessionScope.pageOrder.currentPage + 1}" class="skipBtn"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <span style="font-size: 25px;margin-left: 5px">
            共${sessionScope.pageOrder.totalCount}条记录，共${sessionScope.pageOrder.totalPage}页
        </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
