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
<c:if test="${selectBusInfo == 1}">
    <h3>${product.productName}</h3>
    <p>店铺ID:${business.username}</p>
    <p>店铺负责人:${business.name}</p>
    <p>店铺所在餐厅:${business.rname}</p>
    <p>店铺名字:${business.wname}</p>
    <hr>
    <p>商品简介:${product.productIntr}</p>
    <img src="${ctp}/${product.photosrc}" alt="无法显示">
    <p>商品评分:${product.productGrade}</p>
    <p>商品价钱:${product.productPrice}</p>
</c:if>
<c:if test="${selectBusInfo != 1}">
    <h3>店铺信息获取失败</h3>
</c:if>
</body>
</html>