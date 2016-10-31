<?php

session_start();

$username = $_POST['username'];
$bookId = $_POST['bookId'];

include 'mysqlConnect.php';

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