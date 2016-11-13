angular.module('myApp', ['ngRoute']) //ngRoute is an angular service
.config(function ($routeProvider) {
    $routeProvider.when("/", {
        controller: "loginController",
        templateUrl: "login.html"
    });
    $routeProvider.when("/librarian", {
        controller: "librarianView",
        templateUrl: "librarian.html"
    });
    $routeProvider.when("/undergrad", {
        controller: "undergradView",
        templateUrl: "undergrad.html"
    });
})
.controller('indexController', function($scope) {
})
.controller('loginController', function($scope, $location) {
    $scope.name = "Login";
    $scope.username = "";
    $scope.password = "";

    $scope.checkLogin = function() {
        console.log("Logging in...");
        if ($scope.username == "admin" && $scope.password == "admin") {
            console.log("User is admin");
            $location.path("/librarian");
        } else if ($scope.username[0] == 'U') {
            console.log("User is an undergraduate");
            $location.path("/undergrad");
        } else {
            alert("Username or password were incorrect.");
        }
    }
})
.controller('librarianController', function($scope) {
    $scope.name = "Librarian";
    $scope.username = "admin";
});

