<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>九宫格日记--写日记</title>
<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/write.css" rel="stylesheet">
</head>
<body>
<%@ include file="common/header.jsp"%>

<div class="container">
<div class="form-group">
	<label class="title col-sm-3 control-label">请选择模板：</label>
	<a href="javascript:;" onClick="setTemplate('0')" title="切换主题">默认</a> 
	<a href="javascript:;" onClick="setTemplate('1')">爱心</a> 
	<a href="javascript:;" onClick="setTemplate('2')">太空</a> 
	<a href="javascript:;" onClick="setTemplate('3')">女孩</a>
	<a href="javascript:;" onClick="setTemplate('4')">万圣节</a>
	<a href="javascript:;" onClick="setTemplate('5')">晴空</a>
	<input id="template" name="template" type="hidden" value="0">
</div>
<div class="row diary-bg">
<form>


<div class="form-group white-theme">
<label for="title" class="col-sm-3 col-xs-4 control-label">请输入日记标题：</label>
<div class="col-sm-9 col-xs-8  no-padding">
	<div class="input-group col-sm-8 col-xs-8">
	<span class="input-group-btn">
		<input name="title" id="title" class="form-control" type="text" placeholder="请在此输入标题" onFocus="this.select()">
	</span>
	</div>
</div>
</div>
<!-- --------九宫格区域---------- -->
<div id="writeDiary_bg" class="form-group col-md-12">
<ul id="gridLayout">
<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
		<ul id="opt">
		<li>开心的事</li>
		<li>
	 		<input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  	</li>
	   	<li><a href="javascript:;" onClick="document.getElementsByName('content')[0].value=' 涨工资了'">◎ 涨工资了</a></li>
	   	<li><a href="javascript:;" onClick="document.getElementsByName('content')[0].value='见到了某人'">◎ 见到了某人</a></li>
	   	<li><a href="javascript:;" onClick="document.getElementsByName('content')[0].value='瘦了'">◎ 瘦了</a></li>
	  	<li><a href="javascript:;" onClick="document.getElementsByName('content')[0].value='吃到了美食'">◎ 吃到了美食</a></li>
	  	</ul>
	</div>
</li>
<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
		<ul id="opt">
		<li>为他人做的事</li>
		<li>
	  <input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[1].value='关心同事'">◎ 关心同事</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[1].value='问候家人了'">◎ 问候家人</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[1].value='给老人让坐'">◎ 给老人让坐</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[1].value='忘记了'">◎ 忘记了</a></li></ul>
	</div>
</li>
<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
		<ul id="opt">
		<li>工作/计划/安排</li>
		<li>
	  <input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[2].value='写工作总结'">◎ 写工作总结</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[2].value='出去旅游'">◎ 出去旅游</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[2].value='继续努力工作'">◎ 继续努力工作</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[2].value='休息一下'">◎ 休息一下</a></li></ul>
	</div>
</li>
<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
		<ul id="opt">
		<li>比起昨天的进步</li>
		<li>
	  <input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[3].value='效率提高了'">◎ 效率提高了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[3].value='看书了'">◎ 看书了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[3].value='状态好了'">◎ 状态好了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[3].value='不再空想了'">◎ 不再空想了</a></li></ul>
	</div>
</li>
<li class="col-md-4 col-sm-4 col-xs-6">
	<ul id="weather">
	<li style="height:27px;"> <span id="now" style="font-size: 14px;font-weight:bold;padding-left:5px;">正在获取日期</span>
		<input name="content" type="hidden" value="weathervalue"><br></br>
		<div class="examples">
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="1">
		<img src="<%=request.getContextPath() %>/static/images/weather/1.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="2">
  		<img src="<%=request.getContextPath() %>/static/images/weather/2.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="3">
  		<img src="<%=request.getContextPath() %>/static/images/weather/3.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="4">
  		<img src="<%=request.getContextPath() %>/static/images/weather/4.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="5" checked="checked">
  		<img src="<%=request.getContextPath() %>/static/images/weather/5.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="6">
  		<img src="<%=request.getContextPath() %>/static/images/weather/6.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="7">
  		<img src="<%=request.getContextPath() %>/static/images/weather/7.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="8">
  		<img src="<%=request.getContextPath() %>/static/images/weather/8.png" width="30" height="30">
		</div>
		<div class="col-md-4 col-sm-4 col-xs-6 no-padding" onclick="weatherCheck(this)">
		<input name="weather" type="radio" value="9">
  		<img src="<%=request.getContextPath() %>/static/images/weather/9.png" width="30" height="30">
  		</div>
  		</div>
	</li>
  	</ul>
</li>
<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
	<ul id="opt">
		<li>心情/感情/灵感</li>
	<li>
	  <input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	 </li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[5].value='心情不错'">◎ 心情不错</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[5].value='奥利给'">◎ 奥利给</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[5].value='幸福'">◎ 幸福</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[5].value='神马都是浮云'">◎ 神马都是浮云</a></li></ul>
	</div>
</li>

<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
		<ul id="opt">
		<li>关注/新闻/八卦</li>
		<li>
	  <input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[6].value='TA写九宫格日记了'">◎ TA写九宫格日记了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[6].value='白菜贵了'">◎ 白菜贵了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[6].value='大家都在关注神马'">◎ 大家都在关注神马</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[6].value='新闻联播'">◎ 新闻联播</a></li></ul>
	</div>
</li>

<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
		<ul id="opt">
		<li>健康/体重/饮食</li>
		<li>
	  <input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[7].value='感冒了'">◎ 感冒了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[7].value='胖了'">◎ 胖了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[7].value='健康饮食'">◎ 健康饮食</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[7].value='去健身了'">◎去健身了</a></li></ul>
	</div>
</li>

<li class="col-md-4 col-sm-4 col-xs-6">
	<div class="css-content">
		<ul id="opt">
		<li>梦想/目标</li>
		<li>
	  <input name="content" class="form-control" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[8].value='睡得很好'">◎ 睡得很好</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[8].value='拥有自己的房子'">◎ 拥有自己的房子</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[8].value='忘记了'">◎ 忘记了</a></li>
	   <li><a href="javascript:;" onClick="document.getElementsByName('content')[8].value='努力做好自己'">◎ 努力做好自己</a></li></ul>
	</div>
</li>
</ul>

</div>
</form>
</div>
<div class="form-group col-xs-6 col-xs-offset-3">
	<input class="btn btn-success col-md-4 col-md-offset-4 col-xs-8 col-xs-offset-2" type="button" onclick="pic();" value="预览">
</div>
</div>
<!-- 模态框 图片预览 -->
<!-- Button trigger modal -->
<button id="modal" type="button" class="btn btn-primary btn-lg hidden" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- ----预览图片的Modal----- -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">预 览</h4>
      </div>
      <div class="modal-body">
      <div>加载中</div>
      <div class="image-preview-div"><img src="../../static/images/loading.gif" class="img-responsive image-preview" alt="Responsive image"></div>
      </div>
		<form  id="diaryForm" name="diaryForm" method="POST" action="savediary">
	      	<div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">修 改</button>
	        <input id="saveTitle" name="saveTitle" type="hidden"/>
	        <button type="submit" class="btn btn-primary" >保 存</button>
	      	</div>
        </form>
    </div>
  </div>
</div>
<!-- 通知层 -->
<div class="tip-div col-sm-4 col-xs-6 col-sm-offset-4 col-xs-offset-3">
<div></div>
tips
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/write.js"></script>
</body>
</html>