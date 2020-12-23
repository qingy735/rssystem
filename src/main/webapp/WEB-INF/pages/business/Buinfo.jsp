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
                <button type="button" class="btn btn-primary col-md-8" data-toggle="modal" data-target="#myModal" style="height: 30px">修改信息</button>
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                    <div class="modal-dialog" role="document">
                        <div class="modal-content" style="background-color: seashell;">
                            <form class="form-horizontal" action="" method="post">
                                <div class="modal-header" style="height: 30px;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h5 class="modal-title" id="myModalLabel" style="color: #2e6da4;text-align: center"><b>修改个人信息</b></h5>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="reName" class="col-sm-2 control-label">餐厅名</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" type="text" id="reName">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="wdName" class="col-sm-2 control-label">窗口名</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="wdName" path="wname"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="WdNum" class="col-sm-2 control-label">窗口号</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" id="WdNum" name="wid">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="BuName" class="col-sm-2 control-label"><h6><b>负责人姓名</b></h6></label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="BuName" path="name"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="BuTel" class="col-sm-2 control-label"><h6><b>负责人电话</b></h6></label>
                                        <div class="col-sm-10">
                                            <input type="tel" class="form-control" id="BuTel" path="tel"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="BuPwd1" class="col-sm-2 control-label">密码</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="BuPwd1" name="password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="BuPwd2" class="col-sm-2 control-label">确认密码</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="BuPwd2" name="password2">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <div class="form-group row">
                                            <input type="submit" class="btn btn-primary col-md-2 col-md-offset-8" role="button" value="提交"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

   </div>
</div>
</body>
</html>