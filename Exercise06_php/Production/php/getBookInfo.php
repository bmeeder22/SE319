<?php

$bookId = $_POST['bookId'];

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

//A really sloppy sql query to get the info for the selected book and any umreturned loans
$sql = "SELECT A.book_id, book_title, author, availability, username, due_date, returned_date
FROM ((SELECT *
	FROM books
    WHERE book_id = ".$bookId.")
    AS A
    LEFT JOIN
    (SELECT *
    FROM loan_history
    WHERE book_id = ".$bookId."
    AND returned_date IS NULL)
    AS B
    ON A.book_id = B.book_id);";

$result = $link->query($sql);

if($result == null) {
    echo "Something went wrong! Book info not found.";
    exit();
}

$book = mysqli_fetch_assoc($result);
echo json_encode($book);