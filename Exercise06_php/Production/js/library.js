/**
 * Created by benjaminmeeder on 9/30/16.
 */

$(document).ready(function(){
    var lib = new Library();
});

class Library {
    constructor() {
        $.ajax({
            url: 'php/getUserInfo.php',
            success:  this.setUserInfo.bind(this),
            async: false
        });

        this.render();
    }

    setUserInfo(data) {
        var userInfo = JSON.parse(data);

        this.isLibrarian = userInfo['librarian'];
        this.username = userInfo['username'];
    }

    importBooks(data) {
        data = JSON.parse(data);

        this.art.importBooks(data['art']);
        this.science.importBooks(data['science']);
        this.sport.importBooks(data['sport']);
        this.literature.importBooks(data['literature']);
    }

    render() {
        this.art = new Shelf("Art", this.handleBookClick.bind(this));
        this.science = new Shelf("Science", this.handleBookClick.bind(this));
        this.sport = new Shelf("Sport", this.handleBookClick.bind(this));
        this.literature = new Shelf("Literature", this.handleBookClick.bind(this));

        $.ajax({
            url: 'php/getBooks.php',
            success:  this.importBooks.bind(this),
            async: false
        });

        var table = $('#booksTable');
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

        if(this.isLibrarian == 1) {
            this.renderBookAddOptions();
        }
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

    renderLoanHistory(bookId) {
        console.log("renderLoanHistory");
        var label = $("#loanHistoryLabel");
        label.replaceWith("<h3>Loan History</h3>");

        $.post("php/getLoanHistory.php", {bookId: bookId} ,function(data) {
            var history = JSON.parse(data);

            var div = $("#loanHistory");
            div.empty();

            var subjectRow = document.createElement('tr');

            var usernameLabel = document.createElement('th');
            var titleLabel = document.createElement('th');
            var authorLabel = document.createElement('th');
            var dueDateLabel = document.createElement('th');
            var returnedDateLabel = document.createElement('th');

            usernameLabel.innerHTML = "Username";
            titleLabel.innerHTML = "Title";
            authorLabel.innerHTML = "Author";
            dueDateLabel.innerHTML = "Due Date";
            returnedDateLabel.innerHTML = "Returned Date";

            subjectRow.appendChild(usernameLabel);
            subjectRow.appendChild(titleLabel);
            subjectRow.appendChild(authorLabel);
            subjectRow.appendChild(dueDateLabel);
            subjectRow.appendChild(returnedDateLabel);

            div.append(subjectRow);

            var numLoans = history.length;
            for (var i = 0; i < numLoans; i++) {
                var row = document.createElement('tr');

                var rowUsername = document.createElement('td');
                var rowTitle = document.createElement('td');
                var rowAuthor = document.createElement('td');
                var rowDueDate = document.createElement('td');
                var rowReturnedDate = document.createElement('td');

                rowUsername.innerHTML = history[i]['username'];
                rowTitle.innerHTML = history[i]['book_title'];
                rowAuthor.innerHTML = history[i]['author'];
                rowDueDate.innerHTML = history[i]['due_date'];

                if (history[i]['returned_date'] == null) {
                    rowReturnedDate.innerHTML = "Checked out";
                } else {
                    rowReturnedDate.innerHTML = history[i]['returned_date'];
                }

                row.appendChild(rowUsername);
                row.appendChild(rowTitle);
                row.appendChild(rowAuthor);
                row.appendChild(rowDueDate);
                row.appendChild(rowReturnedDate);

                div.append(row);
            }
        });
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
            shelfId = 1;
        } else if (shelfScience.is(":checked")) {
            shelfId = 2;
        } else if (shelfSport.is(":checked")) {
            shelfId = 3;
        } else {
            shelfId = 4;
        }

        $.ajax({
            url: "php/addBook.php",
            method: "POST",
            data: {
                title: newTitle,
                author: author,
                shelfId: shelfId
            },
            async: false
        });

        this.render();
        bookTitle.val('');
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
        $.post("php/getBookInfo.php",
        {
            bookId: id
        }, this.renderBookInfo.bind(this));
    }

    renderBookInfo(data) {
        if(!data.startsWith('{')) {
            var bookInfoDiv = "<div id='bookInfo'>" + data + "</div>";
            $("#bookInfo").replaceWith(bookInfoDiv);
            return;
        }

        var bookInfo = JSON.parse(data);

        var availability = "";
        var checkOutButton = "";
        var returnButton = "";
        var deleteButton = "";
        var loanHistoryButton = "";

        if(this.isLibrarian == 1)
            loanHistoryButton = "<button id='loanHistoryButton'>View Loan History</button>";

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
        if(this.isLibrarian == 1) {
            deleteButton = "<button id='deleteBookButton'>Delete Book</button>";
        }

        var bookInfoDiv = "<div id='bookInfo'>" + 
            "<h2>Book Info:</h2>" + 
            "<h3>" + bookInfo['book_title'] + "</h3>" + 
            "<p>" + bookInfo['author'] + "</p>" + 
            "<p>" + availability + "</p>" + 
            checkOutButton + returnButton + deleteButton + loanHistoryButton + "</div>";

        $("#bookInfo").replaceWith(bookInfoDiv);

        //if the book is available for checkout, then add the click handler method to the checkout button
        if (bookInfo['availability'] == '1') {
            $("#checkOutButton").click( this.handleCheckoutClick.bind(this, bookInfo['book_id']));
        } else if (bookInfo['username'] == this.username) { //if the book is checked out, the user can return it
            $("#returnButton").click( this.handleReturnBookClick.bind(this, bookInfo['book_id']));
        }

        if (this.isLibrarian == 1) {
            $("#deleteBookButton").click(this.handleDeleteBookClick.bind(this, bookInfo['book_id']));
            $("#loanHistoryButton").click(this.renderLoanHistory.bind(this, bookInfo['book_id']));
        }
    }

    handleDeleteBookClick(bookId) {
        $.ajax({
            url: "php/deleteBook.php",
            method: "POST",
            data: {bookId: bookId},
            async: false
        });

        this.render();
        $("#bookInfo").replaceWith('<div id="bookInfo"></div>');
    }

    handleCheckoutClick(bookId) {
        $.ajax({
            url: "php/checkoutBook.php",
            method: "POST",
            data: {
                bookId: bookId,
                username: this.username
            },
            async: false
        });

        this.render();
        $("#bookInfo").replaceWith('<div id="bookInfo"></div>');
    }

    handleReturnBookClick(bookId) {
        $.ajax({
            url: "php/returnBook.php",
            method: "POST",
            data: {
                bookId: bookId,
            },
            async: false
        });

        this.render();
        $("#bookInfo").replaceWith('<div id="bookInfo"></div>');
    }
}

class Shelf {
    constructor(subject, click) {
        this.subject = subject;
        this.click = click;
        this.books = [];

        this.renderLabel();
    }

    renderLabel() {
        this.label = document.createElement('td');
        this.label.innerHTML = "Shelf " + this.subject;
        this.label.style = "background-color:green";
    }

    importBooks(books) {
        if(books == null) return;

        for(var i = 0; i<books.length; i++) {
            var bookInfo = books[i];
            var newBook = new Book(bookInfo.book_title, bookInfo.book_id, this.click, bookInfo.borrowedBy);
            newBook.checkedOut = bookInfo.checkedOut;
            if(bookInfo.checkedOut) newBook.HTML.style = "background-color:red";
            this.books.push(newBook);
        }
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

        $.post({
            url: 'php/getBookInfo.php',
            data: {bookId: id},
            success: this.getBookInfo.bind(this)
        });
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
        this.click(this.id);
    }

    getUserInfo(data) {
        this.user = JSON.parse(data);
    }

    getBookInfo(data) {
        var data = JSON.parse(data);
        var availability = data['availability'];
        if(availability == 0) this.HTML.style = "background-color:red";
    }
}
