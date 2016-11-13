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
        }
    }
})
.controller('librarianController', function($scope) {
    $scope.name = "Librarian";
    $scope.username = "admin";
});

