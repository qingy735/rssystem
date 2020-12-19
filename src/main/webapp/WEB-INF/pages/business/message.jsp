<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>消息列表</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>
    <script>
        function checkMeAll(){
            //1.获取编号前面的复选框
            var checkAllEle = document.getElementById("checkMeAll");
            //2.对编号前面复选框的状态进行判断
            if(checkAllEle.checked==true){
                //3.获取下面所有的复选框
                var checkOnes = document.getElementsByName("checkMeOne");
                //4.对获取的所有复选框进行遍历
                for(var i=0;i<checkOnes.length;i++){
                    //5.拿到每一个复选框，并将其状态置为选中
                    checkOnes[i].checked=true;
                }
            }else{
                //6.获取下面所有的复选框
                var checkOnes = document.getElementsByName("checkMeOne");
                //7.对获取的所有复选框进行遍历
                for(var i=0;i<checkOnes.length;i++){
                    //8.拿到每一个复选框，并将其状态置为未选中
                    checkOnes[i].checked=false;
                }
            }
        }
        function checkOrAll(){
            //1.获取编号前面的复选框
            var checkAllEle = document.getElementById("checkOrAll");
            //2.对编号前面复选框的状态进行判断
            if(checkAllEle.checked==true){
                //3.获取下面所有的复选框
                var checkOnes = document.getElementsByName("checkOrOne");
                //4.对获取的所有复选框进行遍历
                for(var i=0;i<checkOnes.length;i++){
                    //5.拿到每一个复选框，并将其状态置为选中
                    checkOnes[i].checked=true;
                }
            }else{
                //6.获取下面所有的复选框
                var checkOnes = document.getElementsByName("checkOrOne");
                //7.对获取的所有复选框进行遍历
                for(var i=0;i<checkOnes.length;i++){
                    //8.拿到每一个复选框，并将其状态置为未选中
                    checkOnes[i].checked=false;
                }
            }
        }
    </script>
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea" class="navbar-fixed-top">消息列表</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <br>
    <div>
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#CommentMe" class="changeTab" data-toggle="tab">评论通知<span class="badge">6</span></a></li>
            <li><a href="#OrderMe" class="changeTab" data-toggle="tab">订单通知<span class="badge">6</span></a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="CommentMe">
                <table class="table table-hover" align="center">
                    <!-- 表头-->
                    <thead>
                    <tr align="center" valign="middle">
                        <td width="10%"><input type="checkbox" id="checkMeAll"  onclick="checkMeAll()"></td>
                        <td width="70%">评论通知</td>
                        <td width="20%">时间</td>
                        <td><input type="button" value="置为已读"></td>
                    </tr>
                    </thead>
                    <!--显示数据列表 -->
                    <tbody >
                    <%
                        for(int i=0;i<=5;i++){
                    %>
                    <tr height="60" align="center">
                        <td><input type="checkbox" name="checkMeOne"></td>
                        <td>张三评论了你的菜品</td>
                        <td>2017-11-11 09:30:00</td>
                        <td></td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="OrderMe">
                <table class="table table-hover" align="center">
                    <!-- 表头-->
                    <thead>
                    <tr align="center" valign="middle">
                        <td width="10%"><input type="checkbox" id="checkOrAll" onclick="checkOrAll()"></td>
                        <td width="70%">订单通知</td>
                        <td width="20%">时间</td>
                        <td><input type="button" value="置为已读"></td>
                    </tr>
                    </thead>
                    <!--显示数据列表 -->
                    <tbody id="TableData">
                    <%
                        for(int i=0;i<=5;i++){
                    %>
                    <tr height="60" align="center">
                        <td><input type="checkbox" name="checkOrOne"></td>
                        <td>您有新的订单</td>
                        <td>2017-11-11 09:30:00</td>
                        <td></td>
                    </tr>
                    <%}%>
                    </tbody>
                    <tr></tr>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>