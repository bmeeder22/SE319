<?php

session_start();

$username = $_POST['username'];
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

$updatedLoanHistory = FALSE;
$updateBookAvailability = FALSE;

//Add the checkout to the loan history table

$sql = "INSERT INTO loan_history (username, book_id, due_date)
VALUES ('".$username."', ".$bookId.", CURDATE() + INTERVAL 2 WEEK)";

if ($link->query($sql) === TRUE) {
	$updatedLoanHistory = TRUE;
} else {
    echo "Error: " . $sql . "<br>" . $link->error;
}

//Mark the current book as unavailable

$sql = "UPDATE books
SET availability=0
WHERE book_id=".$bookId.";";

if ($link->query($sql) === TRUE) {
	$updateBookAvailability = TRUE;
} else {
    echo "Error: " . $sql . "<br>" . $link->error;
}

if ($updatedLoanHistory && $updateBookAvailability) {
	echo "success";
}