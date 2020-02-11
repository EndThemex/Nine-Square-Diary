<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>九宫格日记</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="container">
		<div class="row diary-list">

		</div>
	<%@ include file="common/pagination.jsp"%>
	</div>
	<%@ include file="common/footer.jsp"%>
	<script src="<%=request.getContextPath() %>/static/js/index.js"></script>
</body>
</html>