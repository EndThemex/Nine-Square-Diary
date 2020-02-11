// 关键字
var content1 = new Array("星期日","日期一","星期二","星期三","星期四","星期五","星期六");

// 预览
function pic() {
	// 获取所有的日记内容对象
	var contentsObj = document.getElementsByName("content");
	var title = document.getElementById("title").value;
	var template = document.getElementById("template").value
	var weather = $("input:checked").val();
	// 未输入 标题 提示
	if (!title) {
		$(".tip-div").html("请输入标题");
		$(".tip-div").css("visibility", "visible");
		$("#title").css("border-color", "#F39150");
		// 三秒后消失
		setTimeout(function () {
			$(".tip-div").css("visibility", "hidden");
			},3000);
		return;
	} else {
		$("#title").css("border-color", "");
	}
	// 日记内容
	var contents = [];
	for (var i = 0; i < contentsObj.length; i++) {
		// 将默认文字置空
		if (contentsObj[i].value == "请在此输入文字") {
			contents[i] = "";
		} else {
			contents[i] = contentsObj[i].value;
		}
	}
	// 触发模态框
	$("#modal").click();
	$.ajax({
		url:"createimg",
		cache:false, // 设置缓存失效，每次都获取新的内容
		ifModified :true ,
		dataType:"text", 
		type:"POST",
		data:{
	        "title":title,
	        "weather":weather,
	        "template":template,
	        "contents":contents
	    },
	    success:function(res){
	    	$(".image-preview").prop("src", "../../static/images/diary/" + res + ".png");
	    	$("#saveTitle").val(title);
	    }, 
	    async:false
	});
}
// 点击天气图标 选择
function weatherCheck(obj) {
	var checkArr = document.getElementsByName("weather");
	var num = $(obj).children().val();
	for (var i = 0; i < checkArr.length; i++) {
		if (num - 1 == i) {
			$(checkArr[i]).prop("checked", true);
		} else {
			$(checkArr[i]).prop("checked", "");
		}
	}
}
// 设置背景主题
function setTemplate(temp) {
	var img = '0';
	var lastTemplate = document.getElementById("template").value;
	if (lastTemplate == temp) {
		return;
	}
	img = temp;
	document.getElementById("template").value = temp;
	$(".diary-bg").css("background-image", 'url("../../static/images/diarybg/bg_0'+ img +'.jpg")');
}
