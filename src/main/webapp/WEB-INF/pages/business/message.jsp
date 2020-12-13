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
<div id="TitleArea">消息列表</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
<div>
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="#CommentMe" class="changeTab" data-toggle="tab">评论通知<span class="badge">2</span></a></li>
        <li><a href="#OrderMe" class="changeTab" data-toggle="tab">订单通知<span class="badge">1</span></a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="CommentMe">
            <table class="table table-hover" align="center">
                <!-- 表头-->
                <thead>
                <tr align="center" valign="middle">
                    <td width="10%"><input type="checkbox"></td>
                    <td width="70%">评论通知</td>
                    <td width="20%">时间</td>
                </tr>
                </thead>
                <!--显示数据列表 -->
                <tbody >
                <tr height="60" align="center">
                    <td><input type="checkbox"></td>
                    <td>张三评论了你的菜品</td>
                    <td>2017-11-11 09:30:00</td>
                </tr>
                <tr height="60" align="center">
                    <td><input type="checkbox"></td>
                    <td>张三评论了你的菜品</td>
                    <td>2017-11-11 09:30:00</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="tab-pane fade" id="OrderMe">
            <table class="table table-hover" align="center">
                <!-- 表头-->
                <thead>
                <tr align="center" valign="middle">
                    <td width="10%"><input type="checkbox"></td>
                    <td width="70%">评论通知</td>
                    <td width="20%">时间</td>
                </tr>
                </thead>
                <!--显示数据列表 -->
                <tbody id="TableData">
                <tr height="60" align="center">
                    <td><input type="checkbox"></td>
                    <td>您有新的订单</td>
                    <td>2017-11-11 09:30:00</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</body>
</html>