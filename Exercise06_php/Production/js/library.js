/**
 * Created by benjaminmeeder on 9/30/16.
 */

$(document).ready(function(){
    var lib = new Library();
});

class Library {
    constructor() {
        $.get('php/getUserInfo.php', this.setUserInfo.bind(this));
        this.username = this.getURLParameter('user');

        this.checkedOut = 0;

        this.art = new Shelf("Art", this.handleBookClick.bind(this));
        this.science = new Shelf("Science", this.handleBookClick.bind(this));
        this.sport = new Shelf("Sport", this.handleBookClick.bind(this));
        this.literature = new Shelf("Literature", this.handleBookClick.bind(this));

        // this.science.addBooks(["B6", "B7", "B8", "B9", "B10", "B19"]);
        // this.sport.addBooks(["R3", "B11", "B12", "B4", "B5", "R4"]);
        // this.literature.addBooks(["B13", "B14", "B15", "B16", "B17", "B18"]);
        $.post('php/getBooks.php',this.importBooks.bind(this));

        // console.log(this.art);

        this.refreshCookies();
        this.render();
    }

    setUserInfo(data) {
        var userInfo = JSON.parse(data);

        this.isLibrarian = userInfo['librarian'];
    }

    importBooks(data) {
        data = JSON.parse(data);

        this.art.importBooks(data['art']);
        this.science.importBooks(data['science']);
        this.sport.importBooks(data['sport']);
        this.literature.importBooks(data['literature']);

        this.render();
    }

    render() {
        var table = $('table');
        table.empty();

        var subjectRow = document.createElement('tr');

        subjectRow.appendChild(this.art.label);
        subjectRow.appendChild(this.science.label);
        subjectRow.appendChild(this.sport.label);
        subjectRow.appendChild(this.literature.label);

        table.append(subjectRow);

        var rows = this.renderShelves([this.art, this.science, this.sport, this.literature]);

        rows.forEach(
            function (row) {
                table.append(row);
            }
        );

        if(this.isLibrarian) this.renderBookAddOptions();
    }

    refreshCookies() {
        document.cookie = "Art=" + this.art.toString();
        document.cookie = "Science=" + this.science.toString();
        document.cookie = "Sport=" + this.sport.toString();
        document.cookie = "Literature=" + this.literature.toString();
    }

    getCookie(name) {
        var value = "; " + document.cookie;
        var parts = value.split("; " + name + "=");
        if (parts.length == 2) return parts.pop().split(";").shift();
    }

    renderBookAddOptions() {
        var div = $('#adminInputs');
        div.empty();

        var addBookDivTitle = document.createElement('h3');
        addBookDivTitle.innerHTML = "Add a Book:";
        var inputTitle = document.createElement('input');
        inputTitle.id = "addBookTitle";
        inputTitle.placeholder = "Title";
        var author = document.createElement('input');
        author.id = "addBookAuthor";
        author.placeholder = "Author";
        var shelfArt = "<br/><input type='radio' id='shelfArt' name='shelf' value='art'>Art</input>";
        var shelfScience = "<br/><input type='radio' id='shelfScience' name='shelf' value='science'>Science</input>";
        var shelfSport = "<br/><input type='radio' id='shelfSport' name='shelf' value='sport'>Sports</input>";
        var shelfLit = "<br/><input type='radio' id='shelfLiterature' name='shelf' value='literature'>Literature</input><br/>";
        var submit = document.createElement('button');
        submit.innerHTML = "Submit";
        submit.onclick = this.addBook.bind(this);

        div.append(addBookDivTitle);
        div.append(inputTitle);
        div.append(author);
        div.append(shelfArt);
        div.append(shelfScience);
        div.append(shelfSport);
        div.append(shelfLit);
        div.append(submit);
    }

    addBook() {
        var bookTitle = $('#addBookTitle');
        var author = $("#addBookAuthor").val();
        var newTitle = bookTitle.val();
        var shelfArt = $("#shelfArt");
        var shelfScience = $("#shelfScience");
        var shelfSport = $("#shelfSport");
        var shelfLit = $("#shelfLiterature");

        var shelfId = 0;

        var newShelf = '';
        if (shelfArt.is(":checked")) {
            console.log("Adding to shelf art");
            this.art.addBook(newTitle);
            shelfId = 1;
        } else if (shelfScience.is(":checked")) {
            console.log("Adding to shelf science");
            this.science.addBook(newTitle);
            shelfId = 2;
        } else if (shelfSport.is(":checked")) {
            console.log("Adding to shelf sport");
            this.sport.addBook(newTitle);
            shelfId = 3;
        } else {
            console.log("Adding to shelf literature");
            this.literature.addBook(newTitle);
            shelfId = 4;
        }

        console.log("Title: " + newTitle);
        console.log("Author: " + author);
        console.log("ShelfID: " + shelfId);

        $.post("php/addBook.php",
        {
            title: newTitle,
            author: author,
            shelfId: shelfId
        }, function (success) {
            if (success == "success") {
                console.log("Book added successfully");
            }
        });

        bookTitle.val('');

        this.render();
        this.refreshCookies();
    }

    renderShelves(shelves) {
        var rows = [];
        var max = this.getMaxLength(shelves);

        for(var i = 0; i<max; i++) {
            var row = this.renderRow(shelves, i);
            rows.push(row);
        }

        return rows;
    }

    renderRow(shelves, index) {
        var row = document.createElement('tr');
        row.id = "row" + index;

        for(var i = 0; i<shelves.length; i++) {
            try {
                var book = shelves[i].books[index];
                row.appendChild(book.HTML);
            } catch(err) {
                row.appendChild(document.createElement('td'));
            }
        }

        return row;
    }

    getMaxLength(shelves) {
        var max = 0;

        shelves.forEach(
            function (shelf) {
                if(shelf.books.length > max) {
                    max = shelf.books.length;
                }
            }
        );

        return max;
    }

    handleBookClick(id) {
        this.refreshCookies();
        $.post("php/getBookInfo.php",
        {
            bookId: id
        }, this.renderBookInfo.bind(this));
    }

    renderBookInfo(data) {
        var bookInfo = JSON.parse(data);
        // console.log(bookInfo);
        // console.log("this.username: "  + this.username);
        // console.log("Title: " + bookInfo['book_title']);
        var availability = "";
        var checkOutButton = "";
        var returnButton = "";
        var deleteButton = "";
        //Checkout/Return button
        if (bookInfo['availability'] == '0') { //Not available
            availability = "Checked Out";
            if (bookInfo['username'] == this.username) { //if the user is the one who checked out the book, they can return it
                returnButton = "<button id='returnButton'>Return Book</button>";
            }
        } else { //Available for checkout
            availability = "Available";
            checkOutButton = "<button id='checkOutButton'>Check Out</button>";
        }
        //Librarians can delete books
        if (this.isLibrarian) {
            deleteButton = "<button id='deleteBookButton'>Delete Book</button>";
        }
        var bookInfoDiv = "<div id='bookInfo'>" + 
            "<h2>Book Info:</h2>" + 
            "<h3>" + bookInfo['book_title'] + "</h3>" + 
            "<p>" + bookInfo['author'] + "</p>" + 
            "<p>" + availability + "</p>" + 
            checkOutButton + returnButton + deleteButton + "</div>";

        $("#bookInfo").replaceWith(bookInfoDiv);

        //if the book is available for checkout, then add the click handler method to the checkout button
        if (bookInfo['availability'] == '1') {
            // console.log("Checkout Click Button Handler Set");
            $("#checkOutButton").click( this.handleCheckoutClick.bind(this, bookInfo['book_id']));
        } else if (bookInfo['username'] == this.username) { //if the book is checked out, the user can return it
            $("#returnButton").click( this.handleReturnBookClick.bind(this, bookInfo['book_id']));
        }
        if (this.isLibrarian) {
            $("#deleteBookButton").click( this.handleDeleteBookClick.bind(this, bookInfo['book_id']));
        }

        this.render();
        this.refreshCookies();
    }

    handleDeleteBookClick(bookId) {
        console.log("Deleting book with id " + bookId);
        $.post("php/deleteBook.php",
        {
            bookId: bookId
        },
        function (success) {
            if (success == "success") {
                console.log("Book deleted successfully.");
            } else {
                console.log(success);
            }
        });
    }

    getURLParameter(name) {
        return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
    }

    handleCheckoutClick(bookId) {
        console.log("User " + this.username + " wants to check out book with id " + bookId);
        $.post("php/checkoutBook.php",
            {
                bookId: bookId,
                username: this.username
            },
            function (success) {
                console.log(success);
            });
    }

    handleReturnBookClick(bookId) {
        console.log("User " + this.username + " wants to return book with id " + bookId);
        $.post("php/returnBook.php",
            {
                bookId: bookId
            },
            function (success) {
                console.log(success);
            });
    }
}

class Shelf {
    constructor(subject, click) {
        this.bookId = 0;
        this.subject = subject;
        this.renderLabel();
        this.books = [];
        this.click = click;
    }

    renderLabel() {
        this.label = document.createElement('td');
        this.label.innerHTML = "Shelf " + this.subject;
        this.label.style = "background-color:green";
    }

    addBooks(titles) {
        for(var i = 0; i<titles.length; i++) {
            this.addBook(titles[i]);
        }
    }

    importBooks(books) {
        // console.log("Shelf: ")
        // console.log(books);
        for(var i = 0; i<books.length; i++) {
            var bookInfo = books[i];
            var newBook = new Book(bookInfo.book_title, bookInfo.book_id, this.click, bookInfo.borrowedBy);
            newBook.checkedOut = bookInfo.checkedOut;
            if(bookInfo.checkedOut) newBook.HTML.style = "background-color:red";
            this.books.push(newBook);
        }
    }

    addBook(title, author) {
        this.books.push(new Book(title, author, this.subject + this.bookId ,this.click, ""));
        this.bookId++;
        document.cookie = this.subject + "=" + JSON.stringify(this.books);
    }

    toString() {
        return JSON.stringify(this.books);
    }
}

class Book {
    constructor(title, id ,click) {
        this.checkedOut = false;
        this.borrowedBy = "";
        this.title = title;
        this.id = id;
        this.user="";
        $.get('php/getUserInfo.php',
            this.getUserInfo.bind(this)
        );

        this.HTML = this.render(title);

        this.click = click;
    }

    render(title) {
        var HTML = document.createElement('td');
        HTML.innerHTML = title;
        HTML.style = "background-color:white";
        HTML.id = this.id;
        HTML.onclick = this.handleClick.bind(this);

        HTML.className = this.borrowedBy;

        return HTML;
    }

    handleClick() {
        var username = this.user['user'];

        if(username == "admin") {
            this.handleAdminClick();
            return;
        }

        if(this.checkedOut && username != this.borrowedBy) {
            return;
        }

        if(this.checkedOut) {
            var num = $('.' + username).length-1;
            console.log(num);
            if(num <= 2)
                this.checkIn();
            else return;
        }
        else {
            var num = $('.' + username).length+1;
            console.log(num);
            if(num <= 2)
                this.checkOut();
            else return;
        }

        this.click(this.id);
    }

    getUserInfo(data) {
        this.user = JSON.parse(data);
    }

    checkIn() {
        this.HTML.style = "background-color:white";
        this.checkedOut = false;
        this.borrowedBy = "";
        this.HTML.className = "";
    }

    checkOut() {
        this.HTML.style = "background-color:red";
        this.checkedOut = true;
        this.borrowedBy = this.user['user'];
        this.HTML.className = this.borrowedBy;
    }

    handleAdminClick() {
        if(this.checkedOut) {
            $('#adminInfo').html(this.title + " is on shelf " + this.id.substring(0,this.id.length-1) + " and is checked out by " + this.borrowedBy);
        }
        else {
            $('#adminInfo').html(this.title + " is on shelf " + this.id.substring(0,this.id.length-1));
        }
    }
}
