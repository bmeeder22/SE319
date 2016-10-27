<?php

session_start();

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