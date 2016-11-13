angular.module('myApp', ['ngRoute']) //ngRoute is an angular service
.config(function ($routeProvider) {
    $routeProvider.when("/view1", {
        controller: "view1Controller",
        templateUrl: "view1.html"
    });

    $routeProvider.when("/view2", {
        controller: "view2Controller",
        templateUrl: "view2.html"
    });

    $routeProvider.when("/login", {
        controller: "loginController",
        templateUrl: "login.html"
    });
})
.controller('indexController', function($scope) {
})
.controller('loginController', function($scope) {
    $scope.name = "Login";
    $scope.username = "some username";
    $scope.password = "some password";
})
.controller('view1Controller', function($scope) {
	$scope.name = "View1";
	$scope.fullName = "Darth Vader";
	$scope.age = "200";
	$scope.message1 = "You are awesome!";
})
.controller('view2Controller', function($scope) {
	$scope.name = "View2";
  $scope.address = "Death Star";
	$scope.message2 = "Excellent! Thank you!";
});

