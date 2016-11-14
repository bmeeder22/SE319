var currentUser = "";

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
            currentUser = $scope.username;
            $location.path("/librarian");
        } else if ($scope.username[0] == 'U') {
            console.log("User is an undergraduate");
            currentUser = $scope.username;
            $location.path("/undergrad");
        } else {
            alert("Username and/or password was incorrect.");
        }
    }
})

//----------------------LIBRARIAN-------------------------

.controller('librarianController', function($scope, $http, $location) {
    $scope.name = "Librarian";
    $scope.username = "admin";
    $scope.selectedBook = {
        "bookName" : "No book selected",
        "bookType" : "N/A",
        "borrowedBy" : "N/A"
    }

    $scope.logout = function() {
        currentUser = "";
        $location.path("/");
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
        if (bookName == null || bookShelf == null) {
            alert("Not all required fields filled out.");
        } else {
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
    }

    $scope.fetchData();
})

//----------------------UNDERGRAD-------------------------

.controller('undergradController', function($scope, $http, $location) {
    $scope.name = "undergrad";
    $scope.user = currentUser;

    $scope.selectedBook = {
        "bookName" : "No book selected",
        "bookType" : "N/A",
        "borrowedBy" : "N/A"
    }

    $scope.logout = function() {
        currentUser = "";
        $location.path("/");
    }

    $scope.fetchData = function() {
        console.log("Fetching Data...");
        $scope.userCheckedOut = 0;
        $http.get('bookdata.json').
        then(function(response) {
            $scope.shelves = response.data;
            $scope.shelves.forEach(function(shelf) {
                shelf.forEach(function(book) {
                    if(book['borrowedBy'] == $scope.user) {
                        $scope.userCheckedOut += 1;
                    }
                })
            })
            console.log("User has checked out " + $scope.userCheckedOut + " books.");
        }, function() {
            $scope.data = "error";
        });
    }

    $scope.getBookDetails = function(book) {
        $scope.selectedBook = book;
    }

    $scope.saveShelves = function() {
        var jsonShelves = angular.toJson($scope.shelves);
        $.post("saveBookData.php",
            {
                shelves: jsonShelves
            },
            function(data) {
                console.log(data);
        });
    }

    $scope.checkOutBook = function(book) {
        if (book != null) {
            if ($scope.userCheckedOut < 2) {
                console.log("Checking out " + book["bookName"]);
                book['borrowedBy'] = currentUser;
                book['present'] = "0";
                $scope.userCheckedOut++;
                $scope.saveShelves();
            } else {
                alert("You cannot check out more than 2 books at a time.");
            }
        }
    }

    $scope.returnBook = function(book) {
        if (book != null) {
            console.log("Returning " + book["bookName"]);
            book['borrowedBy'] = "N/A";
            book['present'] = "1";
            $scope.userCheckedOut--;
            $scope.saveShelves();
        }
    }

    $scope.fetchData();
});

