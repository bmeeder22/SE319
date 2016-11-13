angular.module('myApp', ['ngRoute']) //ngRoute is an angular service
.config(function ($routeProvider) {
    $routeProvider.when("/login", {
        controller: "loginController",
        templateUrl: "login.html"
    });
})
.controller('indexController', function($scope) {
})
.controller('loginController', function($scope) {
    $scope.name = "Login";
    $scope.username = "";
    $scope.password = "";
});

