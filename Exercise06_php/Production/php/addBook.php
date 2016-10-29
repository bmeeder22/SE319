<?php

$user = 'dbu319t27';
$password = 'cU$RaSp4';
$db = 'db319t27';
$host = 'mysql.cs.iastate.edu';
$port = 3306;

$link = mysqli_init();
$success = mysqli_real_connect(
    $link,
    $host,
    $user,
    $password,
    $db,
    $port
);

$title = $_POST['title'];
$author = $_POST['author'];
$shelfId = $_POST['shelfId'];

$shelfName;
if ($shelfId == 1) {
	$shelfName = "Art";
} else if ($shelfId == 2) {
	$shelfName = "Science";
} else if ($shelfId == 3) {
	$shelfName = "Sport";
} else {
	$shelfName = "Literature";
}

$sql = "INSERT INTO books
	(book_id, book_title, author, availability)
	VALUES ((
		SELECT MAX(book_id)
		FROM shelves) + 1
	, '".$title."', '".$author."', 1)";
// A little trick taking place above: we are using the max from shelves instead of books because MySQL doesn't let
// you do a select on a table that is being inserted into. Since the max book_id in shelves will be
// the same as the max book_id in books, we can get it that way. Then, below, when we update shelves
// we will do the same trick in reverse (not adding a one that time, since we are executing this
// query first). There is probably a better way to do this, but it works for now.

$result = $link->query($sql);

if($result == null) {
    echo "Something went wrong! Book could not be added to books.";
    exit();
}

$sql = "INSERT INTO shelves
	(shelf_id, shelf_name, book_id)
	VALUES (".$shelfId.", '".$shelfName."', (
		SELECT MAX(book_id)
		FROM books)
	)";

$result = $link->query($sql);

if($result == null) {
    echo "Something went wrong! Book could not be added to shelves.";
    exit();
}

echo "success";