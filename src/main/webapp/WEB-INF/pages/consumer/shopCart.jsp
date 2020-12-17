<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctp}/css/myStyle1.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>购物车</title>
</head>
<script type="text/javascript">
    $(function () {
        $(".changeNum").change(function () {
            let val = $(this).val()
            let id = $(this).attr("id")
            $.ajax({
                url: "${ctp}/shop/update?id=" + id + "&pnum=" + val,
                type: "post",
                success:
                    function () {

                    },
                error:
                    function () {

                    }
            })
        })
    })
</script>
<body>

<c:if test="${requestScope.errorInfo != null}">
    <script>
        alert(<%=request.getAttribute("errorInfo")%>)
    </script>
</c:if>

<!-- 导航栏 -->
<jsp:include page="head.jsp"/>
<!-- 加购的餐品列表 -->
<c:if test="${sessionScope.shops == null}">
    <div style="width: 100%;text-align: center;">
        <img style="align-content: center;width: 20%;" class="notfound" src="${ctp}/images/nofound.png">
        <span>您还没有加购任何商品，快去选购吧~</span>
    </div>
</c:if>
<c:if test="${sessionScope.shops != null}">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <td></td>
                <th>商品</th>
                <th>价格</th>
                <th>购买数量</th>
                <th>优惠券</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <form action="${ctp}/checkout/shops" method="post">
                <c:forEach items="${sessionScope.shops}" var="shop">
                <tr style="text-align:center">
                    <td>
                        <input type="checkbox" name="checkout" value="${shop.id}">
                    </td>
                    <td style="width: 20%;height: 20%">
                        <a><!--跳转商品详情-->
                            <img alt="生菜" style="width: 50%" src="${ctp}/${shop.product.photosrc}">
                        </a>
                    </td>
                    <td>${shop.product.productPrice}</td>
                    <td>
                        <input name="pnum" id="${shop.id}" value="${shop.pnum}" type="number" class="changeNum">
            </form>
            </td>
            <td>-${shop.discountuse}</td>
            <td>${shop.totalPrice}</td>
            <td>
                <a href="${ctp}/checkout/shop?id=${shop.id}" class="del">结账</a>
                <a href="${ctp}/shop/delete?id=${shop.id}" class="del">删除</a>
            </td>
            </tr>
            </c:forEach>
            </form>
            </tbody>
        </table>
    </div>
</c:if>

<div class="row countPrice col-md-12 ">
    <div class="inCountPrice">
        <div class="countPrice1 " style="float: left">
            <input type="checkbox">&nbsp;全选&nbsp;
        </div>
        <div class="countPrice1" style="float: left">
            <a>删除&nbsp;</a>
        </div>
        <div class="countPrice1 form-inline" style="float: left">
            <label class="form-inline">已选择商品&nbsp;0&nbsp;件</label>
        </div>
        <div style="float: right">
            <button type="button" class="btn btn-warning">结&nbsp;算</button>
        </div>
        <div class="countPrice1" style="float: right">
            <span style="color: red"> &nbsp;5.00&nbsp;&nbsp;</span>
        </div>
        <div class="countPrice1" style="float: right">
            <span>总金额：</span>
        </div>

    </div>
</div>
</body>
</html>