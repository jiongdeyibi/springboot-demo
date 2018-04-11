$(document).ready(function islogin() {
    $.ajax({
        type : "GET",
        url : "/hello/getuser",
        dataType : "text",
        success : function (data) {
            $("#user-name").text(data);
            console.log(data)
        }
    })
    var islg=document.getElementById("user-name").innerHTML;
    // console.log(islg)
    $("#login-button").hide();
    $("#welcome-text").show();
    $("#logout-button").show();
    if(islg==null||islg==''){
        switchframe('login.jsp')
        $("#login-button").show();
        $("#welcome-text").hide();
        $("#logout-button").hide();
    }
});
function switchframe(page) {
    var ifm = document.getElementById("indexframe");
    ifm.src = page;
};
function refreshhead() {
    window.location.reload()
};

