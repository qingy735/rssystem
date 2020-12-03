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
<frameset rows="100%">
	<frameset rows="15%,85%" frameborder="no" >
		<frame src="${ctp}/business/top" name="topFrame" id="topFrame"/>
		<frameset cols="15%,85%" frameborder="no" >
			<frame src="${ctp}/business/left" name="leftFrame" id="leftFrame"/>
			<frame src="${ctp}/updateProducts" name="mainFrame" id="mainFrame"
				   scrolling="yes" />
		</frameset>
	</frameset>
	<noframes>
		<body>您的浏览器无法处理此框架
		</body>
	</noframes>
</frameset>
</html>