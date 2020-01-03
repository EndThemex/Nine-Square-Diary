var storage = localStorage;
$(document).ready(function() {
    var checkbox = document.getElementsByName("isRemeberPassword");
    // Remember password
    var isRemember = storage.getItem("isRemember");
    if (isRemember == "true") {
        checkbox[0].checked = true;
        document.getElementById("userName").value = storage.getItem("userName");
        document.getElementById("password").value = storage.getItem("password");
    } else {
        checkbox[0].checked = false;
        document.getElementById("userName").value = storage.getItem("userName");
        document.getElementById("password").value = storage.getItem("password");
    }
});

$("#loginButton").click(function() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var flag = true;
    if (userName) {
        $("#userName").css("border-color", "");
    } else {
        $("#userName").css("border-color", "#F39150");
        flag = false;
    }
    if (password) {
        $("#password").css("border-color", "");
    } else {
        $("#password").css("border-color", "#F39150");
        flag = false;
    }
    if (!flag) {
        $(".login-messages").html("请输入用户名和密码");
        $(".login-messages").removeClass("invisible");
    } else {
        rememberPassword(userName, password)
        $(".login-messages").removeClass("visible");
        $("#loginForm").submit();
    }
});

function rememberPassword(userNameValue, passwordValue) {
    var checkObj = document.getElementById("loginCheckBox");
    var flag = false;
    if (checkObj.checked) {
        flag = true;
        storage.setItem("userName", userNameValue);
        storage.setItem("password", passwordValue);
    } else {
        storage.setItem("userName", "");
        storage.setItem("password", "");
    }
    var isRemember = storage.setItem("isRemember", flag);
}