<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>个人信息</title>
</head>
<body>
<header class="container">
    <div class="row">
        <div class="col-md-10"><h1>河南大学餐厅服务系统</h1></div>
        <div class="col-md-2"><a href="${ctp}/consumer/logout"><h1>退出登录</h1></a></div>
    </div>
</header>
<div>
    <label>姓名：${sessionScope.conLoginInfo.name}</label><br>
    <label>性别：${sessionScope.conLoginInfo.sex == 1 ? "男" : "女"}</label><br>
    <label>账号：${sessionScope.conLoginInfo.username}</label><br>
    <label>昵称：${sessionScope.conLoginInfo.nickname}</label><br>
    <label>电话：${sessionScope.conLoginInfo.tel}</label><br>
</div>
</body>
</html>