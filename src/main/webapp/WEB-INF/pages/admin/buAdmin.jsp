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
<div id="TitleArea">商家信息管理</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="TopMainArea">
    <div class="container searchPdt">
        <form id="selectForm" class="form-inline" method="post" action="${ctp}/admin/businesses">
            <div class="form-group">
                <label for="username">商家id</label>
                <input type="text" class="form-control" id="username" name="username"
                       value="${sessionScope.busConds.username}">
            </div>
            <div class="form-group">
                <label for="wname">窗口名</label>
                <input type="text" class="form-control" id="wname" name="wname" value="${sessionScope.busConds.wname}">
            </div>
            <div class="form-group">
                <label for="rname">餐厅名</label>
                <input type="text" class="form-control" id="rname" name="rname"
                       value="${sessionScope.busConds.rname}">
            </div>
            <div class="form-group">
                <label for="grade">评分不低于</label>
                <input type="text" class="form-control" id="grade" name="grade"
                       value="${sessionScope.busConds.grade}">
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
            <td>餐厅名</td>
            <td>窗口号</td>
            <td>窗口名</td>
            <td>电话号码</td>
            <td>评分</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="orderListData">
        <c:forEach items="${sessionScope.pageBus.list}" var="business">
            <tr height="60" align="center">
                <td>${business.username}</td>
                <td>${business.password}</td>
                <td>${business.name}</td>
                <td>${business.rname}</td>
                <td>${business.wid}</td>
                <td>${business.wname}</td>
                <td>${business.tel}</td>
                <td>${business.grade}</td>
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
                    <c:when test="${sessionScope.pageBus.currentPage == 1}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/admin/businesses?p=${sessionScope.pageBus.currentPage - 1}" class="skipBtn"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <c:forEach begin="1" end="${sessionScope.pageBus.totalPage}" var="i">
                    <c:if test="${sessionScope.pageBus.currentPage == i}">
                        <li class="active">
                            <a href="${ctp}/admin/businesses?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.pageBus.currentPage != i}">
                        <li>
                            <a href="${ctp}/admin/businesses?p=${i}" class="skipBtn">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:choose>
                    <c:when test="${sessionScope.pageBus.currentPage == sessionScope.pageBus.totalPage}">
                        <li class="disabled">
                            <a href="javascript:void(0)"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${ctp}/admin/businesses?p=${sessionScope.pageBus.currentPage + 1}" class="skipBtn"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <span style="font-size: 25px;margin-left: 5px">
            共${sessionScope.pageBus.totalCount}条记录，共${sessionScope.pageBus.totalPage}页
        </span>
            </ul>
        </nav>
    </div>

</div>
</body>
</html>
