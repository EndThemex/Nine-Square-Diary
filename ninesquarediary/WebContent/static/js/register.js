var loginFlag = true;
$("#registerButton").click(function() {
    $("#userName").blur();
    $("#nickName").blur();
    $("#phone").blur();
    $("#password").blur();
    $("#password2").blur();
    $("#checkCode").blur();
});

$("#userName").blur(function() {
	checkNullVal("userName");
	var str = $("#userName").val();
	if (!str) {
		$("#userNameTip").html("请输入用户名");
	    return;
	}
	// 用户名需包含字母和数字
	var reg = new RegExp(/^(?![^a-zA-Z]+$)(?!\D+$)/);
	if (reg.test(str)) {
		$("#userNameTip").css("display", "none");
        $("#userName").css("border-color", "");
	} else {
		$("#userNameTip").css("display", "inline");
		$("#userNameTip").html("用户名不合法");
        $("#userName").css("border-color", "#F39150");
        loginFlag = false;
	}
});
$("#nickName").blur(function(){
    checkNullVal("nickName");
});
$("#phone").blur(function(){
    checkNullVal("phone");
    var phone = $("#phone").val();
	if (!phone) {
		$("#phoneTip").html("请输入手机号码");
	    return;
	}
    // 手机号正则
    if((/^1[3456789]\d{9}$/.test(phone))){ // 正确手机号码
		$("#phoneTip").css("display", "none");
        $("#phone").css("border-color", "");
	} else {
		$("#phoneTip").css("display", "inline");
		$("#phoneTip").html("请输入正确的号码");
        $("#phone").css("border-color", "#F39150");
        loginFlag = false;
	}
});
$("#password").blur(function(){
    checkNullVal("password");
    var password = $("#password").val();
	if (!password) {
		$("#passwordTip").html("请输入密码");
	    return;
	} else {
		$("#password2").val("");
	}
    if (password.length >= 6) {
    	$("#passwordTip").css("display", "none");
        $("#password").css("border-color", "");
	} else {
		$("#passwordTip").css("display", "inline");
		$("#passwordTip").html("密码最少6位");
        $("#password").css("border-color", "#F39150");
        loginFlag = false;
	}
});

$("#password2").blur(function(){
    checkNullVal("password2");
    var password2 = $("#password2").val();
	if (!password2) {
		$("#password2Tip").html("请确认密码");
	    return;
	}
	var password1 = $("#password").val();
    if (password2 == password1) {
    	$("#password2Tip").css("display", "none");
        $("#password2").css("border-color", "");
	} else {
		$("#password2Tip").css("display", "inline");
		$("#password2Tip").html("两次密码输入不一致");
        $("#password2").css("border-color", "#F39150");
        loginFlag = false;
	}
});

$("#checkCode").blur(function(){
    checkNullVal("checkCode");
});

// 发送验证码倒计时
$("#sendCode").click(function() {
    $("#phone").blur();
    var val = $("#phone").val();
    $("#sendCode").blur();
    if (!val) {
    return;
    }
    var time = 60; //倒计时60秒
    var timeCode = setInterval(function() {
    if (time > 0) {
        time = time - 1;
        $("#sendCode").val(time + "秒后重新发送");
    } else {
        clearInterval(timeCode);
        $("#sendCode").val("重新发送验证码");
    }
    }, 1000);
});

function checkNullVal(id) {
    var val = $("#" + id).val();
    val = val.trim();
    if (!val) { // 内容为空
        $("#" + id + "Tip").css("display", "inline");
        $("#" + id).css("border-color", "#F39150");
        loginFlag = false;
    } else {        
    	$("#" + id + "Tip").css("display", "none");
        $("#" + id).css("border-color", "");
    }
    $("#" + id).val(val);
}