<%@page import="com.endtheme.ninesquarediary.util.StringUtil"%>
<%@page import="com.endtheme.ninesquarediary.util.SessionUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>九宫格日记--用户登陆</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/login.css" rel="stylesheet">
</head>
<body>
    <%@ include file="common/header.jsp"%>

    <%
    String tipMessage = (String) SessionUtil.getSession("TIP_MESSAGE");
    String hidden = "";
    if (StringUtil.isEmpty(tipMessage)) {
        hidden = "invisible";
    }
    SessionUtil.addSession("TIP_MESSAGE", "");
    %>
    <div class="container">
      <div class="page-title">
        <h3>用户登陆:</h3>
      </div>
        <div class="login-form-div col-sm-12">
            <form class="col-sm-offset-2 col-sm-8" id="loginForm" action="login" method="POST">
                <div class="form-group col-sm-offset-2 col-sm-8 text-center">
                    <div class="login-messages <%=hidden %> text-center"><%=tipMessage %></div>
                </div>
                <div class="form-group col-sm-offset-2 col-sm-8">
                    <label for="userName">用户名/手机号码</label>
                    <input type="text" class="form-control col-sm-6" id="userName" name="userName" placeholder="用户名/手机号码" maxlength="55"/>
                </div>
                <div class="form-group col-sm-offset-2 col-sm-8">
                    <label for="password">密码</label>
                    <input type="password" class="form-control col-sm-6 warring-input" id="password" name="password" placeholder="密码" maxlength="55"/>
                </div>
                <div class="checkbox col-sm-offset-2 col-sm-8">
                    <label class="col-sm-5"><input name="isRemeberPassword" id="loginCheckBox" type="checkbox"> 记住密码  </label> 
                    <label class="col-sm-offset-2 col-sm-5 text-right forget-pwd"> 忘记密码？ </label>
                </div>
                <div class="form-group col-sm-offset-2 col-sm-8 login-button-div">
                    <input type="button" id="loginButton" class="btn btn-success col-sm-offset-1 col-sm-4" value="登陆" />
                    <input type="button" id="registerButton" class="btn btn-success col-sm-offset-2 col-sm-4" value="注册" />
                </div>
            </form>
        </div>
    </div>

    <%@ include file="common/footer.jsp"%>
    <script src="<%=request.getContextPath() %>/static/js/login.js"></script>
</body>
</html>