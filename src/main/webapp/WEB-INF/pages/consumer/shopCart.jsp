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
        // 修改购物车中商品数量
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
        // 结算购物车选中商品
        $("#checkoutBtu").click(function () {
            var ids = GetShopNum()
            $.ajax({
                url: "${ctp}/checkout/shops",
                type: "post",
                data: {'ids': ids},
                traditional: true,
                dataType: "json",
                success:
                    function (data) {
                        if (data.flag == false) {
                            alert("结账失败")
                        }
                        location.href = "${ctp}" + data.href
                    },
                error:
                    function () {
                        alert("错误")
                    }
            })
            return false;
        })

    })

    //全选操作
    function checkShopAll() {
        //1.获取编号前面的复选框
        var checkAllEle = document.getElementById("checkShopAll");
        //2.对编号前面复选框的状态进行判断
        if (checkAllEle.checked == true) {
            //3.获取下面所有的复选框
            var checkOnes = document.getElementsByName("checkout");
            //4.对获取的所有复选框进行遍历
            for (var i = 0; i < checkOnes.length; i++) {
                //5.拿到每一个复选框，并将其状态置为选中
                checkOnes[i].checked = true;
            }
        } else {
            //6.获取下面所有的复选框
            var checkOnes = document.getElementsByName("checkout");
            //7.对获取的所有复选框进行遍历
            for (var i = 0; i < checkOnes.length; i++) {
                //8.拿到每一个复选框，并将其状态置为未选中
                checkOnes[i].checked = false;
            }
        }
    }

    //获取选择的商品数量--Id
    function GetShopNum() {
        var checkOnes = document.getElementsByName("checkout");
        var Shops = [];
        for (var i = 0; i < checkOnes.length; i++) {
            if (checkOnes[i].checked == true) {
                Shops.push(checkOnes[i].value);
            }
        }
        return Shops;
    }
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
<c:if test="${sessionScope.mapShop == null}">
    <div style="width: 100%;text-align: center;">
        <img style="align-content: center;width: 20%;" class="notfound" src="${ctp}/images/nofound.png">
        <span>您还没有加购任何商品，快去选购吧~</span>
    </div>
</c:if>
<c:if test="${sessionScope.mapShop != null}">
    <%--<div id="TableMain">
        <table class="table table-hover tableMain" align="center">
            <!-- 表头-->
            <thead>
            <tr align="center" valign="middle">
                <td>&nbsp;</td>
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
                            <input name="pnum" id="${shop.id}" value="${shop.pnum}" type="number" class="changeNum"
                                   style="width: 120px">
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
    </div>--%>
    <div id="TableMain">
        <c:forEach items="${sessionScope.mapShop}" var="shops">
            <h4>商家id：${shops.key}</h4>
            <table class="table table-hover tableMain" align="center">
                <!-- 表头-->
                <thead>
                <tr align="center" valign="middle">
                    <td>&nbsp;</td>
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
                    <c:forEach items="${shops.value}" var="shop">
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
                                <input name="pnum" id="${shop.id}" value="${shop.pnum}" type="number" class="changeNum"
                                       style="width: 120px">
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
        </c:forEach>
    </div>
    <div class="row countPrice col-md-12 navbar-fixed-bottom">
        <div class="inCountPrice">
            <div class="col-md-1 pull-left">
                <input type="checkbox" id="checkShopAll" onclick="checkShopAll()">&nbsp;全选&nbsp;
            </div>
            <div class="col-md-1 pull-left">
                <a>删除</a>
            </div>
            <div class="col-md-2 pull-left">
                <label class="form-inline">已选择商品&nbsp;0&nbsp;件</label>
            </div>
            <div class="col-md-1 pull-right">
                <button type="button" class="btn btn-warning" id="checkoutBtu">结&nbsp;算</button>
            </div>
            <div class="col-md-2 pull-right">
                <span>总金额：</span>
                <span style="color: red"> &nbsp;5.00&nbsp;&nbsp;</span>
            </div>
        </div>
    </div>
</c:if>

</body>
</html>