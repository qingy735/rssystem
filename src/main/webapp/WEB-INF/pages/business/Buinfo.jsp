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
<div id="TitleArea"  class="navbar-fixed-top">个人中心</div>
<div class="container" id="TopMainArea">
    <br><br>
    <div class="row">
        <div class="col-md-2 onePage">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <img src="${ctp}/images/henu.jpg" class="img-circle" style="width: 100px">
                    <br>
                    <label id="">商家编号:${sessionScope.busLoginInfo.username}</label>
                </div>
            </div>
            肯德基（Kentucky Fried Chicken，肯塔基州炸鸡，简称KFC），
            是美国跨国连锁餐厅之一，也是世界第二大速食及最大炸鸡连锁企业，
            1952年由创始人哈兰·山德士（Colonel Harland Sanders）创建，
            [1]  主要出售炸鸡、汉堡、薯条、盖饭、蛋挞、汽水等高热量快餐食品。
            中国肯德基隶属于百胜中国控股有限公司（简称“百胜中国”） [2]  ，
            股票代码为YUMC [2]  ，是Yum。Brands在中国大陆的特 许经营商 [2]
            ，拥有肯德基品牌在中国大陆的独家经营权。
        </div>
        <div class="col-md-8 onePage">
            <label class="col-md-12" style="text-align: center">个人信息</label><br>
            <div>
                <table class="table  table-bordered" align="center">
                    <thead>
                    <tr id="TableTitle">
                        <td>店铺负责人</td>
                        <td>店铺所在餐厅ID</td>
                        <td>店铺所在餐厅</td>
                        <td>店铺所在窗口ID</td>
                        <td>店铺所在窗口</td>
                        <td>负责人电话号码</td>
                    </tr>
                    </thead>
                    <tbody id="orderDetailData">
                    <tr align="center">
                        <td>${sessionScope.busLoginInfo.name}</td>
                        <td>${sessionScope.busLoginInfo.rid}</td>
                        <td>${sessionScope.busLoginInfo.rname}</td>
                        <td>${sessionScope.busLoginInfo.wid}</td>
                        <td>${sessionScope.busLoginInfo.wname}</td>
                        <td>${sessionScope.busLoginInfo.tel}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <button type="button" value="修改信息" class="btn-primary col-md-8" style="height: 30px">修改信息</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>