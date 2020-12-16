<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>河南大学餐厅服务系统</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 页面标题 -->
<h3>${sessionScope.updateInfo}</h3>
<div id="TitleArea">更新新餐品</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <div class="row" id="mainArea">
        <form action="${ctp}/product/update?id=${updateProduct.id}" class="proForm" enctype="multipart/form-data"
              method="post">
            <div class="form-group">
                <label for="proName" class="col-md-4 control-label">餐品名称:</label>
                <div class="col-md-8 col-md-pull-2">
                    <input type="text" class="form-control" id="proName" name="productName"
                           value="${updateProduct.productName}"><br>
                </div>
            </div>
            <div class="form-group">
                <label for="proInfo" class="col-md-4 control-label">餐品简介：</label>
                <div class="col-md-8  col-md-pull-2">
                    <textarea cols="20" rows="5" class="form-control" id="proInfo" name="productIntr">
                        ${updateProduct.productIntr}
                    </textarea>
                    <br>
                </div>
            </div>
            <div class="form-group">
                <label for="proPrice" class="col-md-4 control-label">餐品价格:</label>
                <div class="col-md-8  col-md-pull-2">
                    <input type="text" class="form-control" id="proPrice" name="productPrice"
                           value="${updateProduct.productPrice}"><br>
                </div>
            </div>

            <div class="form-group">
                <label for="image" class="col-md-4 control-label">餐品图片:</label>
                <div class="col-md-8  col-md-pull-2">
                    <img src="${ctp}/${updateProduct.photosrc}?id=<%=Math.random()%>" alt="无法显示">
                    <input type="file" id="image" name="imgSrc"/>
                </div>
                <br>
            </div>
            <div class="form-group col-md-6 col-md-offset-6">
                <input type="submit" value="提交" class="btn btn-primary col-md-4 pull-left">
                <a href="${ctp}/business/productList" class="btn btn-primary col-md-4 pull-right" role="button">返回</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>