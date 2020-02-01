<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>九宫格日记--个人中心</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../common/header.jsp"%>
	<div class="container">
		<div class="row">
			<!-- 个人资料 -->
			<div class="col-sm-3 col-md-3">
				<h3>个人资料</h3>
				<p>用户名：<%=user.getUserName() %></p>
				<p>性    别：<%=user.getGender() %></p>
				<p>地    址：<%=user.getAddress() %></p>
				<p>用户名：<%=user.getUserName() %></p>
			</div>
			<!-- 个人动态 -->
			<div class="col-sm-9 col-md-9">
				<h3>个人动态</h3>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="<%=request.getContextPath() %>/static/images/demo.png" alt="...">
						<div class="caption">
							<h3>日记标题</h3>
							<p><%=user.getUserName() %></p>
							<p>时间</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">编 辑</a> 
								<a href="#" class="btn btn-default" role="button">删 除</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="<%=request.getContextPath() %>/static/images/demo.png" alt="...">
						<div class="caption">
							<h3>日记标题</h3>
							<p><%=user.getUserName() %></p>
							<p>时间</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">编 辑</a> 
								<a href="#" class="btn btn-default" role="button">删 除</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>	
		
	</div>
<%@ include file="../common/footer.jsp"%>
</body>
</html>