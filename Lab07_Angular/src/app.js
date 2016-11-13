angular.module('myApp', ['ngRoute']) //ngRoute is an angular service
.config(function ($routeProvider) {
    $routeProvider.when("/", {
        controller: "loginController",
        templateUrl: "login.html"
    });
    $routeProvider.when("/librarian", {
        controller: "librarianController",
        templateUrl: "librarian.html"
    });
    $routeProvider.when("/undergrad", {
        controller: "undergradController",
        templateUrl: "undergrad.html"
    });
})
.controller('indexController', function($scope) {
})

//----------------------LOGIN-------------------------

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
            alert("Username and/or password was incorrect.");
        }
    }
})

//----------------------LIBRARIAN-------------------------

.controller('librarianController', function($scope, $http) {
    $scope.name = "Librarian";
    $scope.username = "admin";
    $scope.selectedBook = {
        "bookName" : "No book selected",
        "bookType" : "N/A",
        "borrowedBy" : "N/A"
    }

    $scope.fetchData = function() {
        console.log("Fetching Data...");
        $http.get('bookdata.json').
        then(function(response) {
            $scope.shelves = response.data;
        }, function() {
            $scope.data = "error";
            console.log(response.data)
        });
    }

    $scope.getBookDetails = function(book) {
        $scope.selectedBook = book;
    }

    $scope.saveShelves = function() {
        var jsonShelves = angular.toJson($scope.shelves);
        console.log("JSON shelves: " + jsonShelves);
        $.post("saveBookData.php",
            {
                shelves: jsonShelves
            },
            function(data) {
                console.log(data);
        });
    }

    $scope.addBook = function(bookName, bookShelf, bookType) {
        console.log("Adding book: " + bookName + " of type " + bookType + " to shelf " + bookShelf);
        var isReference = "Ordinary";
        if (bookType) {
            isReference = "Reference";
        }
        var newBook = {
            "bookName" : bookName,
            "bookType" : isReference,
            "borrowedBy" : "N/A",
            "presesnt" : "1"
        }

        var shelfLocation = $scope.shelves[bookShelf].length;
        $scope.shelves[bookShelf][shelfLocation] = newBook;

        $scope.saveShelves();
    }

    $scope.fetchData();
})

//----------------------UNDERGRAD-------------------------

.controller('undergradController', function($scope, $http) {
    $scope.name = "undergrad";

    $scope.selectedBook = {
        "bookName" : "No book selected",
        "bookType" : "N/A",
        "borrowedBy" : "N/A"
    }

    $scope.fetchData = function() {
        console.log("Fetching Data...");
        $http.get('bookdata.json').
        then(function(response) {
            $scope.shelves = response.data;
        }, function() {
            $scope.data = "error";
            console.log(response.data)
        });
    }

    $scope.getBookDetails = function(book) {
        $scope.selectedBook = book;
    }

    $scope.checkOutBook = function(book) {
        console.log("Checking out " + book["bookName"]);
    }

    $scope.fetchData();
});

