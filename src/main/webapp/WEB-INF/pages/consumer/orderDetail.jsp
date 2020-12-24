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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单详情</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/myStyle1.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
    <h3 class="col-md-12" style="text-align: center"><b>订单详情</b></h3>
</div>
<c:if test="${details != null}">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr align="center" valign="middle">
                <td>店铺：${details[0].product.business.wname}</td>
                <td><b>商品</b></td>
                <td><b>名称</b></td>
                <td><b>价格</b></td>
                <td><b>购买数量</b></td>
                <td><b>优惠券</b></td>
                <td><b>小计</b></td>
                <td><b>操作</b></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${details}" var="detail">
                <tr align="center">
                    <td>&nbsp;</td>
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
                    <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                            style="height: 30px">添加评论
                </button></td>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content" style="background-color: seashell;margin-top: 15%">
                                <form class="form-horizontal" action="" method="post">
                                    <div class="modal-header" style="height: 40px;">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                                aria-hidden="true">&times;</span></button>
                                        <h5 class="modal-title" id="myModalLabel" style="color: #2e6da4;text-align: center">
                                            <b>添加评论</b></h5>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <div class="col-md-8 col-md-offset-2">
                                        <textarea cols="20" rows="8" class="form-control" id="proInfo" name="productIntr">
                                        </textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <div class="form-group row">
                                            <input type="submit" class="btn btn-primary col-md-2 col-md-offset-8"
                                                   role="button" value="提交"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row">
            <p class="col-md-12" style="text-align: center">合计：${order.total}</p>
        </div>
    </div>
</c:if>
<c:if test="${details == null}">
    <p>订单查询出现错误</p>
</c:if>
</body>
</html>
