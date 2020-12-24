<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctp}/css/pInfoStyle.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        $(function () {
            setTimeout(function () {
                var info = "<%=request.getAttribute("updateInfo")%>"
                if (info != "null") {
                    alert(info)
                }
            },400)
        })
    </script>

    <title>个人信息</title>
</head>
<body>

<header class="container">
    <jsp:include page="head.jsp"/>
</header>
<div class="allInfo">
    <img src="${ctp}/images/person01.png" width="10%">
    <table>
        <tr>
            <td>姓名：</td>
            <td>${sessionScope.conLoginInfo.name}</td>
            <td></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>${sessionScope.conLoginInfo.sex == 1 ? "男" : "女"}</td>
            <td></td>
        </tr>
        <tr>
            <td>账号：</td>
            <td>${sessionScope.conLoginInfo.username}</td>
            <td></td>
        </tr>
        <tr>
            <td>昵称：</td>
            <td>${sessionScope.conLoginInfo.nickname}</td>
            <td>
                <form method="post" action="${ctp}/consumer/updatenick">
                    <input class="newNickName" name="nickname" type="text" placeholder="输入新昵称..">
                    <input class="changeNickName" type="submit" value="修改昵称">
                </form>
            </td>
        </tr>
        <tr>
            <td>电话：</td>
            <td>${sessionScope.conLoginInfo.tel}</td>
            <td></td>
        </tr>
        <tr>
            <td>修改密码：</td>
            <td colspan="2">
                <form method="post" action="${ctp}/consumer/updatepass">
                    <input class="oldPassword" name="password" type="text" placeholder="输入当前密码..">
                    <input class="newPassword" name="newPassword" type="text" placeholder="输入新密码..">
                    <input class="changePassword" type="submit" value="修改密码">
                </form>
            </td>
        </tr>
    </table>
    <%--    <label>姓名：${sessionScope.conLoginInfo.name}</label><br>--%>
    <%--    <label>性别：${sessionScope.conLoginInfo.sex == 1 ? "男" : "女"}</label><br>--%>
    <%--    <label>账号：${sessionScope.conLoginInfo.username}</label><br>--%>
    <%--    <label>昵称：${sessionScope.conLoginInfo.nickname}</label><br>--%>
    <%--    <label>电话：${sessionScope.conLoginInfo.tel}</label><br>--%>
</div>

</body>
</html>