#drop tables users, books, loan_history, shelves;

create table users (
	username Varchar(255),
	password varchar(255),
	email varchar(255),
	phone int(10),
	librarian tinyint,
	first_name varchar(255),
	last_name varchar(255),
	primary key(username)
);

create table books (
	book_id int(10),
	book_title varchar(255),
    author varchar(255),
    availability tinyint,
    deleted bool default false,
    primary key(book_id)
);

create table loan_history (
	username varchar(255),
    book_id int(10),
    due_date date,
    returned_date date
);

create table shelves (
	shelf_id int(10),
    shelf_name varchar(255),
    book_id int(10)
);