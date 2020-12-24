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
    <link rel="stylesheet" type="text/css" href="${ctp}/css/detailStyle.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>

</head>
<body>
<div id="TitleArea" class="navbar-fixed-top">餐品详情</div>
<div id="mainArea">
    <br><br>
  <div class="row">
      <div class="col-md-8 onePage">
          <div class="proBusiness">
              <div class="tip_proB">
                  <img src="${ctp}/images/busi01.png" class="proBimg">
              </div>
              <div class="proBinfo">
              <p>店铺ID:${product.business.username}</p>
              <p>店铺负责人:${product.business.name}</p>
              <p>店铺所在餐厅:${product.business.rname}</p>
              <p>店铺名字:${product.business.wname}</p>
              </div>
          </div>
          <h3>${add_info}</h3>
          <h3 class="prodDiName">${product.productName}</h3>
          <img src="${ctp}/images/segment01.png" class="segmentHr">
          <br>
          <br>
          <div class="detProInfo">
              <br>
              <div class="proInfoImg">
          <img src="${ctp}/${product.photosrc}" alt="无法显示" class="proDuImg">
              </div>
              <div class="proInfoCont">
                  <p>商品简介:${product.productIntr}</p>
                  <p>商品评分:${product.productGrade}</p>
                  <p>商品价钱:${product.productPrice}</p>
                  <form action="${ctp}/shop/add?pid=${product.id}&bid=${product.bid}" method="post">
              份数：<input type="number" class="pronum" name="pnum">
              <input type="submit" class="putintocart" value="加入购物车">
          </form>
                  <br>
                  <br>
              </div>
          </div>
      </div>
      <div class="col-md-2 onePage">
          <label class="col-md-12" style="text-align: center;">评价</label>
      </div>

  </div>
</div>

</body>
</html>