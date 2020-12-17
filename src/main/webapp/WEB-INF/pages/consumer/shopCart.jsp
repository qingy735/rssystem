<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/myStyle1.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
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
<div id="TableMain">
    <table class="table table-hover tableMain" align="center">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle">
            <td><input type="checkbox"/></td>
            <td>商品</td>
            <td>价格</td>
            <td>购买数量</td>
            <td>优惠券</td>
            <td>小计</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody>

        <form action="${ctp}/checkout/shops" method="post">
            <c:forEach items="${sessionScope.shops}" var="shop">
                <tr height="60" align="center">
                    <td>
                        <input type="checkbox" name="checkout" value="${shop.id}">
                    </td>
                    <td>
                        <a><!--跳转商品详情-->
                            <img alt="生菜" style="height:60px" src="${ctp}/${shop.product.photosrc}">
                        </a>
                    </td>
                    <td>${shop.product.productPrice}</td>
                    <td>
                        <input name="pnum" id="${shop.id}" value="${shop.pnum}" type="number" class="changeNum" style="width: 120px">
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