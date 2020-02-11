<%@page import="com.endtheme.ninesquarediary.util.SessionUtil"%>
<%@page import="com.endtheme.ninesquarediary.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<link href="<%=request.getContextPath() %>/static/css/common/header.css" rel="stylesheet">
</head>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/common/header.util.js"></script>

<%
User user = (User) SessionUtil.getSession("user");
%>

<div class="jumbotron header-div pl-2">
    <h2 class="webfont">九宫格日记网站</h2>
    <div class="row daily-words-div">
        <div class="col-xs-12">每日一句 今日：<span class="daily-date"></span></div>
        <div class="col-xs-12 daily-words"></div>
        <div class="col-xs-12 daily-words-en"></div>
    </div>
</div>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand webfont" title="九宫格日记" href="#">九宫格日记</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="../user/welcome">首 页 </a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <%
        // 未-登-录-菜-单
        if (user == null) {
        %>
        <li><a href="../user/login">登 陆</a></li>
        <li><a href="../user/register">注 册</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">更 多 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="http://www.endtheme.cn">关于</a></li>
          </ul>
        </li>
        <%
        } else {
        	//  登-录-后
        %>
        <li><a href="#">欢迎你：<%=user.getUserName() %></a></li>
        <li><a href="../diary/write">写日记</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">更多 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="../user/myspace">个人中心</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="../user/logout">退出登陆</a></li>
          </ul>
        </li>
        <%    
        }
        %>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- 面包屑导航 -->
<ol class="breadcrumb">
  <li class="breadcrumb-home"><a href="../user/welcome">首页</a></li>
</ol>

</html>