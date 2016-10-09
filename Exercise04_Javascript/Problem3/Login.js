/**
 * Created by benjaminmeeder on 9/30/16.
 */
var handleLogin = function() {
    var username = $("#username").val();
    var pass = $("#password").val();

    console.log(username);
    console.log(pass);

    if(username == "admin" && pass == "admin") {
        window.location = "adminview.html?user=" + username;
    }
    else if(username == "U") {
        window.location = "underview.html";
    }
    else {
        alert("this is not a valid username or password");
    }
};
