<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>餐品详情</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/myStyle1.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>

</head>
<body>
<div id="TitleArea" class="navbar-fixed-top">餐品详情</div>
<br><br>
<div id="mainArea">
    <h3>${add_info}</h3>
    <h3>${product.productName}</h3>
    <p>店铺ID:${product.business.username}</p>
    <p>店铺负责人:${product.business.name}</p>
    <p>店铺所在餐厅:${product.business.rname}</p>
    <p>店铺名字:${product.business.wname}</p>
    <hr>
    <p>商品简介:${product.productIntr}</p>
    <img src="${ctp}/${product.photosrc}" alt="无法显示" style="height:100px">
    <p>商品评分:${product.productGrade}</p>
    <p>商品价钱:${product.productPrice}</p>
    <form action="${ctp}/shop/add?pid=${product.id}&bid=${product.bid}" method="post">
        份数：<input type="number" name="pnum"><br>
        <input type="submit" value="加入购物车">
    </form>

</div>

</body>
</html>