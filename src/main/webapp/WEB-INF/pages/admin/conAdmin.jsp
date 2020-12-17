<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员界面</title>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctp}/css/index.css"/>
    <script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${ctp}/js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $(".skipBtn").click(function () {
                // 改变表单action指向
                $("#selectForm").attr("action", this.href)
                // 提交表单
                $("#selectForm").submit();
                return false;
            })
        })
    </script>

</head>
<body>
<div id="TitleArea">消费者信息管理</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <div class="container searchPdt">
        <form id="selectForm" class="form-inline" method="post" action="${ctp}/admin/consumers">
            <div class="form-group">
                <label for="username">用户id</label>
                <input type="text" class="form-control" id="username" name="username"
                       value="${sessionScope.conConds.username}">
            </div>
            <div class="form-group">
                <label for="nickname">昵称</label>
                <input type="text" class="form-control" id="nickname" name="nickname"
                       value="${sessionScope.conConds.nickname}">
            </div>
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name"
                       value="${sessionScope.conConds.name}">
            </div>
            <div class="form-group">
                <label for="sex">性别</label>
                <input type="text" class="form-control" id="sex" name="sex"
                       value="${sessionScope.conConds.sex}">
            </div>
            <input type="submit" class="btn btn-default" value="搜索"/>
        </form>
    </div>
    <table class="table table-hover" align="center">
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>用户名</td>
            <td>密码</td>
            <td>姓名</td>
            <td>昵称</td>
            <td>性别</td>
            <td>电话号码</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="orderListData">
        <c:forEach items="${sessionScope.pageCon.list}" var="consumer">
            <tr height="60" align="center">
                <td>${consumer.username}</td>
                <td>${consumer.password}</td>
                <td>${consumer.name}</td>
                <td>${consumer.nickname}</td>
                <td>${consumer.sex}</td>
                <td>${consumer.tel}</td>
                <td>
                    <a onclick="return confirm('确定要删除吗？')" class="btn">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- 分页条 -->
    <div class="middle container divPage">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${sessionScope.pageCon.currentPage == 1}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/admin/consumers?p=${sessionScope.pageCon.currentPage - 1}" class="skipBtn"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <c:forEach begin="1" end="${sessionScope.pageCon.totalPage}" var="i">
                    <c:if test="${sessionScope.pageCon.currentPage == i}">
                        <li class="active">
                            <a href="${ctp}/admin/consumers?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.pageCon.currentPage != i}">
                        <li>
                            <a href="${ctp}/admin/consumers?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:choose>
                    <c:when test="${sessionScope.pageCon.currentPage == sessionScope.pageCon.totalPage}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/admin/consumers?p=${sessionScope.pageCon.currentPage + 1}" class="skipBtn"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <span style="font-size: 25px;margin-left: 5px">
            共${sessionScope.pageCon.totalCount}条记录，共${sessionScope.pageCon.totalPage}页
        </span>
            </ul>
        </nav>
    </div>

</div>
</body>
</html>
