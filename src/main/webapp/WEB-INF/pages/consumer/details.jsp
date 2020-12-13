<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>餐品详情</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<h3>${add_info}</h3>
<c:if test="${error_info == true}">
    <h3>${product.productName}</h3>
    <p>店铺ID:${product.business.username}</p>
    <p>店铺负责人:${product.business.name}</p>
    <p>店铺所在餐厅:${product.business.rname}</p>
    <p>店铺名字:${product.business.wname}</p>
    <hr>
    <p>商品简介:${product.productIntr}</p>
    <img src="${ctp}/${product.photosrc}" alt="无法显示">
    <p>商品评分:${product.productGrade}</p>
    <p>商品价钱:${product.productPrice}</p>
</c:if>
<c:if test="${error_info == false}">
    <h3>商品信息获取失败</h3>
</c:if>
<form action="${ctp}/shop/add?pid=${product.id}&bid=${product.business.username}" method="post">
    份数：<input type="number" name="pnum"><br>
    折扣：<input type="number" name="discountuse"><br>
    <input type="submit" value="加入购物车">
</form>
</body>
</html>