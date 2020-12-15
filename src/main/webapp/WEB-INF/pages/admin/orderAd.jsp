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
<div id="TitleArea">订单管理</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <table class="table table-hover" align="center">
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>订单编号</td>
            <td>消费者用户名</td>
            <td>下商家用户名</td>
            <td>备注</td>
            <td>code(是啥？)</td>
            <td>状态</td>
            <td>订单日期</td>
            <td>电话号码</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="orderListData">
        <% for(int i=0; i<=5;i++){
        %>
        <tr height="60" align="center">
            <td>1</td>
            <td>1812030001</td>
            <td>100001</td>
            <td>备注</td>
            <td>。。。</td>
            <td>已结账</td>
            <td>2020-12-13 20:46:12</td>
            <td>12345678900</td>
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
