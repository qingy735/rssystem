<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div id="TitleArea">菜品列表</div>
<!-- 过滤条件 -->
<div id="TopMainArea">
    <form action="${ctp}/business/" method="get">
        <input type="hidden" name="method" value="search"> <input
            type="text" name="keyword" title="请输入菜品名称"> <input
            type="submit" value="搜索">
    </form>
    <table class="table table-hover" align="center">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>餐品编号</td>
            <td>餐品名称</td>
            <td>价格</td>
            <td>餐品类型</td>
            <td>图片</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <c:forEach items="${sessionScope.products}" var="product" varStatus="u">
            <tr height="60" align="center">
                <td>${u.count}</td>
                <td>${product.productName}</td>
                <td>${product.productPrice}</td>
                <td>菜&nbsp;</td>
                <td>
                    <img border="0" width="20" height="20" src="${ctp}/${product.photosrc}" alt="暂无图片"/>&nbsp;
                </td>
                <td>
                    <a href="${ctp}/business/updateProducts?id=${product.id}">更新</a>
                    <a href="${ctp}/product/delete?id=${product.id}" onclick="return confirm('确定要删除吗？')">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="TableTail" align="center">
        <div class="btn">
            <a href="${ctp}/business/uploadProducts">添加</a>
        </div>
    </div>
</div>
<!-- 主内容区域（数据列表或表单显示） -->

</body>
</html>
