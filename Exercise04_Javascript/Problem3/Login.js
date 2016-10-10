/**
 * Created by benjaminmeeder on 9/30/16.
 */
var handleLogin = function() {
    var username = $("#username").val();
    var pass = $("#password").val();

    console.log(username);
    console.log(pass);

    if(username == "admin" && pass == "admin") {
        window.location = "BooksLibrary.html?user=" + username;
    }
    else if(username.includes("U")) {
        window.location = "BooksLibrary.html?user=" + username;
    }
    else {
        alert("this is not a valid username or password");
    }
};
