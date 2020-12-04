<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctp}/css/myStyle1.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>修改密码</title>
</head>
<body>
<form action="${ctp}/consumer/updatepass" class="form-horizontal" role="form" method="post">
    <h3 class="altpw col-md-offset-6">修改密码</h3>
    <input type="hidden" name="_update" value="pass">
    <div class="form-group">
        <label class="col-md-offset-4 col-sm-2 control-label" for="password">请输入密码：</label>
        <input id="password" name="password" type="password"><br>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-md-offset-4 control-label" for="newPassword">请输入新密码：</label>
        <input id="newPassword" name="newPassword" type="password"><br>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-md-offset-4 control-label" for="newPassword2">请确认新密码：</label>
        <input id="newPassword2" type="password"><br>
    </div>
    <input class=" col-md-offset-6 control-label" type="submit" value="修改">
</form>
<h3>${updateInfo}</h3>
</body>
</html>