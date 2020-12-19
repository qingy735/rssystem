<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
</head>
<body>
<div id="TitleArea" class="navbar-fixed-top">个人中心</div>
<div class="container" id="TopMainArea">
    <br><br>
    <div class="row">
        <div class="col-md-2 onepage">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <img src="${ctp}/images/henu.jpg" class="img-circle" style="width: 100px">
                    <br>
                    <label id="">商家编号:${sessionScope.busLoginInfo.username}</label>
                </div>
            </div>
        </div>
        <div class="col-md-6 onepage">
            店铺负责人：${sessionScope.busLoginInfo.name}<br>
            店铺所在餐厅ID：${sessionScope.busLoginInfo.rid}<br>
            店铺所在餐厅：${sessionScope.busLoginInfo.rname}<br>
            店铺所在窗口ID：${sessionScope.busLoginInfo.wid}<br>
            店铺所在窗口：${sessionScope.busLoginInfo.wname}<br>
            店铺负责人电话号码：${sessionScope.busLoginInfo.tel}
        </div>
        <div class="col-md-2 onepage">
            xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        </div>
    </div>
</div>
</body>
</html>