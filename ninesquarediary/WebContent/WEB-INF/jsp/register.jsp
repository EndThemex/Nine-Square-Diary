<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>九宫格-注册账号</title>
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/register.css" rel="stylesheet">
  </head>
  <body>
    <%@ include file="common/header.jsp"%>
    <div class="container">
      <div class="page-title">
        <h3>注册账号:</h3>
      </div>
      <div class="register-form-div">
        <form class="form-horizontal col-sm-offset-1 col-sm-10" id="registerForm">
        
          <div class="form-group">
            <label for="userName" class="col-sm-3 control-label">用户名</label>
            <div class="col-sm-5">
              <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名(需包含字母和数字)"/>
            </div>
            <div class="col-sm-4 text-left tip" id="userNameTip">用户名不空</div>
          </div>
          
          <div class="form-group">
            <label for="nickName" class="col-sm-3 control-label">昵称</label>
            <div class="col-sm-5">
              <input type="text" class="form-control" id="nickName" placeholder="昵称">
            </div>
            <div class="col-sm-4 text-left tip" id="nickNameTip">昵称不能为空</div>
          </div>
          
          <div class="form-group">
            <label for="gender1" class="col-sm-3 control-label">性别</label>
            <div class="col-sm-5">
              <label class="radio-inline">
              <input type="radio" name="gender" id="gender1" checked value="男"> 男
              </label>
              <label class="radio-inline">
              <input type="radio" name="gender" id="gender2" value="女"> 女
              </label>
            </div>
            <div class="col-sm-4 text-left tip" id="genderTip">请选择性别</div>
          </div>
          
          <div class="form-group">
            <label for="password" class="col-sm-3 control-label">密码</label>
            <div class="col-sm-5">
              <input type="password" class="form-control" id="password" placeholder="密码">
            </div>
            <div class="col-sm-4 text-left tip" id="passwordTip">请输入密码</div>
          </div>
          
          <div class="form-group">
            <label for="password2" class="col-sm-3 control-label">确认密码</label>
            <div class="col-sm-5">
              <input type="password" class="form-control" id="password2" placeholder="确认密码">
            </div>
            <div class="col-sm-4 text-left tip" id="password2Tip">请确认密码</div>
          </div>
          
          <div class="form-group">
            <label for="phone" class="col-sm-3 control-label">手机号码</label>
            <div class="col-sm-5">
              <div class="input-group">
                <input type="number" class="form-control" id="phone" placeholder="手机号码">
                <span class="input-group-btn">
                  <input class="btn btn-default" type="button" id="sendCode" value="发送验证码"/>
                </span>
              </div>
            </div>
            <div class="col-sm-4 text-left tip" id="phoneTip">请填写手机号码</div>
          </div>
          
          <div class="form-group">
            <label for="checkCode" class="col-sm-3 control-label">验证码</label>
            <div class="col-sm-5">
              <input type="text" class="form-control" id="checkCode"
                placeholder="验证码">
            </div>
            <div class="col-sm-4 text-left tip" id="checkCodeTip">请输入验证码</div>
          </div>
          
          <div class="col-sm-offset-3 col-sm-8 register-div">
            <input type="button" id="registerButton" class="btn btn-success col-sm-offset-1 col-sm-2" value="注 册" />
            <input type="button" class="btn btn-warning col-sm-offset-2 col-sm-2" value="取 消" />
          </div>
          
        </form>
      </div>
    </div>
    <%@ include file="common/footer.jsp"%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/register.js"></script>
  </body>
</html>