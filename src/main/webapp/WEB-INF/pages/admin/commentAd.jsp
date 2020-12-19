<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员界面</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body>
<div id="TitleArea" class="navbar-fixed-top">评价管理</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <br><br>
    <table class="table table-hover" align="center">
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>编号</td>
            <td>商家用户名</td>
            <td>餐品名</td>
            <td>评分</td>
            <td>评论</td>
            <td>消费者用户名</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="orderListData">
        <% for(int i=0; i<=5;i++){
        %>
        <tr height="60" align="center">
            <td>1</td>
            <td>100001</td>
            <td>糖醋里脊</td>
            <td>5.6</td>
            <td>好吃好吃好吃</td>
            <td>1812030001</td>
            <td>
                <a onclick="return confirm('确定要删除吗？')" class="btn">删除</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
