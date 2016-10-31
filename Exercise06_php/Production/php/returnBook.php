<?php

session_start();

$bookId = $_POST['bookId'];

include 'mysqlConnect.php';

$updatedLoanHistory = FALSE;
$updateBookAvailability = FALSE;

//Add the return to the loan history table

$sql = "UPDATE loan_history
SET returned_date = CURDATE()
WHERE book_id = ".$bookId." AND returned_date IS NULL";

if ($link->query($sql) === TRUE) {
	$updatedLoanHistory = TRUE;
} else {
    echo "Error: " . $sql . "<br>" . $link->error;
}

//Mark the current book as available

$sql = "UPDATE books
SET availability=1
WHERE book_id=".$bookId.";";

if ($link->query($sql) === TRUE) {
	$updateBookAvailability = TRUE;
} else {
    echo "Error: " . $sql . "<br>" . $link->error;
}

if ($updatedLoanHistory && $updateBookAvailability) {
	echo "success";
}