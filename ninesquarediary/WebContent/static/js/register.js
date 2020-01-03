var flag = true;
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
});
$("#nickName").blur(function(){
    checkNullVal("nickName");
});
$("#phone").blur(function(){
    checkNullVal("phone");
});
$("#password").blur(function(){
    checkNullVal("password");
});
$("#password2").blur(function(){
    checkNullVal("password2");
});
$("#checkCode").blur(function(){
    checkNullVal("checkCode");
});

$("#sendCode").click(function() {
    $("#phone").blur();
    var val = $("#phone").val();
    $("#sendCode").blur();
    if (!val) {
    return;
    }
    var time = 12;
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
    if (!val) {
        $("#" + id + "Tip").css("display", "inline");
        $("#" + id).css("border-color", "#F39150");
        flag = false;
    } else {        
    	$("#" + id + "Tip").css("display", "none");
        $("#" + id).css("border-color", "");
    }
    $("#" + id).val(val);
}