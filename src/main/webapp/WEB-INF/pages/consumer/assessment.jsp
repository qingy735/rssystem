<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
   <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>我的评价</title>
</head>
<body>
<header class="container">
   <jsp:include page="head.jsp"/>
</header>
<body>
<div  class="navbar-fixed-top" id="TitleArea">评价列表</div>
<!-- 过滤条件 -->
<div id="TopMainArea">
   <br><br>
   <form action="${ctp}/business/commentList" method="post">
      &nbsp;
      <input type="search" name="name" value="${name}" placeholder="请输入菜品名称">
      <input type="submit" value="搜索">
      <br>
   </form>
   <table class="table table-hover" align="center">
      <!-- 表头-->
      <thead>
      <tr align="center" valign="middle" id="TableTitle">
         <td>评价编号</td>
         <td>评价餐品</td>
         <td>评价商家</td>
         <td>评价内容</td>
         <td>评分</td>
      </tr>
      </thead>
      <!--显示数据列表 -->
      <tbody id="TableData">
      <c:forEach items="${sessionScope.comment}" var="comment" varStatus="u">
         <tr height="60" align="center">
            <td>${u.count}</td>
            <td>${comment.bid}</td>
            <td>${comment.pid}</td>
            <td>${comment.comment}</td>
            <td>${comment.grade}</td>

            <td></td>
            <td>
               <a href="${ctp}/comment/delete?id=${comment.id}" onclick="return confirm('确定要删除吗？')">删除</a>
            </td>
         </tr>
      </c:forEach>
      </tbody>
   </table>
</div>
<!-- 主内容区域（数据列表或表单显示） -->

</body>
</body>
</html>