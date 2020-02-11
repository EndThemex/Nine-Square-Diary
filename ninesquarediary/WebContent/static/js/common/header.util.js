$(document).ready(function() {
    $.getJSON("https://api.ooopn.com/ciba/api.php", function(result) {
        $(".daily-date").text(result.date);
        $(".daily-words").text(result.ciba);
        $.each(result, function(i, words) {
            if (i == "ciba-en") {
                $(".daily-words-en").text(words);
            }
        });
    });
    randomImg();
    getUrl();
    nowTime();
    // 加载日记
    loadDiary();
});
function randomImg() {
    // 背景图片 利用图床
    var imagesArr = new Array();
    imagesArr[0] = "https://s2.ax1x.com/2020/01/03/lUqPv6.jpg";
    imagesArr[1] = "https://s2.ax1x.com/2020/01/03/lULQY9.jpg";
    imagesArr[2] = "https://s2.ax1x.com/2020/01/03/lUqGVg.jpg";
    imagesArr[3] = "https://s2.ax1x.com/2020/01/03/lUq3qS.jpg";
    imagesArr[4] = "https://s2.ax1x.com/2020/01/03/lUq1r8.jpg";
    imagesArr[5] = "https://s2.ax1x.com/2020/01/03/lUqlKf.jpg";
    imagesArr[6] = "https://s2.ax1x.com/2020/01/03/lUqPv6.jpg";
    imagesArr[7] = "https://i.loli.net/2020/02/09/N2uQh5Gw3EjdcWT.png";
    
    var x = imagesArr.length - 1;
    var y = 0;
    var rand = parseInt(Math.random() * (x - y + 1) + y);
    var num = rand;
    $("body").css({"background-image": "url(" + imagesArr[num] + ")", "background-repeat": "no-repeat", "background-position": "center 0", "background-size": "cover"});
}
String.prototype.trim = function() {
	  return this.replace(/(^\s*) | (\s*$)/g,"");
	}

	String.prototype.ltrim = function() {
	  return this.replace(/(^\s*)/g,"");
	}

	String.prototype.rtrim = function() {
	  return this.replace(/(\s*$)/g,"");
	}

	// 获取URL 面包屑
	function getUrl()
	{
	       var query = window.location.pathname;
	       var vars = query.split("/");
	       if (vars[4] == "welcome") {
	    	   return;
	       }
	       for (i = 3; vars.length - i > 0; i++) {
	    	   if (i < vars.length) {
		    	   $(".breadcrumb").append('<li><a href="#">'+ vars[i] +'</a></li>');
	    	   } else {
	    		   var obj = $(".breadcrumb").append('<li class="active"><a href="#">'+ vars[i] +'</a></li>');
	    		   $.parser.parse(obj);
	    	   }
	       }
	       //alert(vars[2]); page
	}
	// 获取当前的时间
	function nowTime() {
	    var query = window.location.pathname;
	    var vars = query.split("/");
	    if (vars[4] != "write") {
	 	   return;
	    }
		var date=new Date();		//创建日期对象
		year=date.getFullYear();	//获取当前日期中的年份
		month=date.getMonth();		//获取当前日期中的月份
		day=date.getDate();			//获取当时日期中的日
		week=date.getDay();			//获取当前日期中的星期
		var arr=new Array("星期日","日期一","星期二","星期三","星期四","星期五","星期六");
		document.getElementById("now").innerHTML="日期：" + year + "年" + (month + 1) + "月" + day + "日 " + arr[week];
	}
