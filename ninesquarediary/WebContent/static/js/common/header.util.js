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
});
function randomImg() {
    var num = 1;
    // 背景图片 利用图床
    var imagesArr = new Array();
    imagesArr[0] = "https://s2.ax1x.com/2020/01/03/lUqPv6.jpg";
    imagesArr[1] = "https://s2.ax1x.com/2020/01/03/lULQY9.jpg";
    imagesArr[2] = "https://s2.ax1x.com/2020/01/03/lUqGVg.jpg";
    imagesArr[3] = "https://s2.ax1x.com/2020/01/03/lUq3qS.jpg";
    imagesArr[4] = "https://s2.ax1x.com/2020/01/03/lUq1r8.jpg";
    imagesArr[5] = "https://s2.ax1x.com/2020/01/03/lUqlKf.jpg";
    imagesArr[6] = "https://s2.ax1x.com/2020/01/03/lUqPv6.jpg";
    var x = imagesArr.length - 1;
    var y = 0;
    var rand = parseInt(Math.random() * (x - y + 1) + y);
    num = rand;
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