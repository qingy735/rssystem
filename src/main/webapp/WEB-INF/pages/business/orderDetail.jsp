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
    <div id="TitleArea">订单详细说明</div>
    <!-- 主内容区域（数据列表或表单显示） -->
    <div id="TopMainArea">
            <table  class="table table-bordered Dtabel" align="center">
                <thead>
                <tr id="TableTitle">
                    <td>订单ID</td>
                    <td>备注</td>
                    <td>取餐码</td>
                    <td>下单时间</td>
                    <td>状态</td>
                    <td>是否使用折扣</td>
                    <td>消费者学号</td>
                    <td>消费者姓名</td>
                    <td>消费者昵称</td>
                    <td>消费者电话号码</td>
                    <td>商品id</td>
                    <td>商品名字</td>
                    <td>商品单价</td>
                    <td>商品数量</td>
                </tr>
                </thead>
                <tbody id="orderDetailData">
                <tr align="center">
                    <td>00000001</td>
                    <td>多放辣椒不要香菜</td>
                    <td>54</td>
                    <td>Sat Nov 28 00:36:06 CST 2020</td>
                    <td>0</td>
                    <td>0</td>
                    <td>1812030021</td>
                    <td>张三</td>
                    <td>这是新昵称</td>
                    <td>12345678900</td>
                    <td>1</td>
                    <td>糖醋排骨</td>
                    <td>5.0</td>
                    <td>1</td>
                </tr>
                </tbody>
            </table>
        </div>

</div>
</body>
</html>