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
    <title>修改昵称</title>

    <script>
        $(function () {

        })
    </script>

</head>
<body>
<form action="${ctp}/consumer/updatenick" class="form-horizontal" role="form" id="updateForm" method="post">
    <h3 class="altpw col-md-offset-6">修改昵称</h3>
    <input type="hidden" name="_update" value="nick">
    <div class="form-group">
        <label class="col-md-offset-4 col-sm-2 control-label" for="nickname">请输入新昵称：</label>
        <input type="text" name="nickname" id="nickname"><br>
        <input type="submit" value="修改">
    </div>
</form>
<h3>${updateInfo}</h3>
</body>
</html>