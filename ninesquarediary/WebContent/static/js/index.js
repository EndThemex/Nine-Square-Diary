function loadDiary() {
	console.log("日志信息");
	$.ajax({
		url:"../diary/queryalldiary",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		type:"POST",
		data:{
			"curentPage":1
		},
		success:function(res){
			console.log(res);
			if (res == "") {
				$(".diary-list").prepend('<div class="col-sm-6 col-md-4"><div class="thumbnail">'+
						'<img src="../../static/images/diary/de.jpg" alt="...">' + 
						'<div class="caption"><h3>暂无内容</h3><p>请稍后再试</p>'+
						'</div></div></div>');
			} else {
				var data = $.parseJSON(res);
				console.log("riji:" + res + "\n" + data.diaryList[0].nickName);
				for (var i = 0; i < data.diaryList.length; i++) {
					$(".diary-list").prepend('<div class="col-sm-6 col-md-4"> <div class="thumbnail">' + 
							'<img src="../../static/images/demo.png" alt="...">' + 
							'<div class="caption"><h3>' + data.diaryList[i].title + '</h3>' + 
								'<p>用户' + data.diaryList[i].nickName + '</p><p><a href="#" class="btn btn-primary" role="button">点赞</a> ' +
									'<a href="#" class="btn btn-default" role="button">评论(' + data.diaryList[i].commentCount + ')</a>' +
								'</p></div></div></div>');
				}
				$(".pagination").css("visibility", "visibile");
			}

		},
		error:function(res){
			console.log("shibai:" + res.toString);
		},
		dataType:"text"
	});
}