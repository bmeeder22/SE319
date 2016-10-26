/**
 * Created by benjaminmeeder on 9/30/16.
 */

$(document).ready(function(){
    var lib = new Library();
});

class Library {
    constructor() {
        this.username = this.getURLParameter('user');
        console.log("Username: " + this.username);

        this.checkedOut = 0;

        this.art = new Shelf("Art", this.handleBookClick.bind(this));
        this.science = new Shelf("Science", this.handleBookClick.bind(this));
        this.sport = new Shelf("Sport", this.handleBookClick.bind(this));
        this.literature = new Shelf("Literature", this.handleBookClick.bind(this));

        // this.science.addBooks(["B6", "B7", "B8", "B9", "B10", "B19"]);
        // this.sport.addBooks(["R3", "B11", "B12", "B4", "B5", "R4"]);
        // this.literature.addBooks(["B13", "B14", "B15", "B16", "B17", "B18"]);
        $.post('php/getBooks.php',this.importBooks.bind(this));

        console.log(this.art);

        this.refreshCookies();
        this.render();
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

        if(this.username == 'admin') this.renderBookAddOptions();
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

        var inputTitle = document.createElement('input');
        inputTitle.id = "addBook";
        var inputId = document.createElement('input');
        inputId.id = "BookID";
        var submit = document.createElement('button');
        submit.innerHTML = "Submit";
        submit.onclick = this.addBook.bind(this);

        div.append(inputTitle);
        div.append(inputId);
        div.append(submit);
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
        console.log("Getting info for book " + id);
        $.post("php/getBookInfo.php",
        {
            bookId: id
        }, function (data) {
            console.log("data: " + data);
        });
    }

    addBook() {
        var bookTitle = $('#addBook');
        var bookID = $('#BookID');
        var newTitle = bookTitle.val();
        var newID = bookID.val();

        bookTitle.val('');
        bookID.val('');

        switch(newID) {
            case '1':
                this.art.addBook(newTitle);
                break;
            case '2':
                this.science.addBook(newTitle);
                break;
            case '3':
                this.sport.addBook(newTitle);
                break;
            case '4':
                this.literature.addBook(newTitle);
                break;
        }

        this.render();
        this.refreshCookies();
    }

    getURLParameter(name) {
        return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
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
        console.log("Shelf: ")
        console.log(books);
        for(var i = 0; i<books.length; i++) {
            var bookInfo = books[i];

            var newBook = new Book(bookInfo.book_title, bookInfo.book_id, this.click, bookInfo.borrowedBy);
            newBook.checkedOut = bookInfo.checkedOut;
            if(bookInfo.checkedOut) newBook.HTML.style = "background-color:red";
            this.books.push(newBook);
        }
    }

    addBook(title) {
        this.books.push(new Book(title, this.subject + this.bookId ,this.click, ""));
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
        console.log("user: " + this.user);

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
