<?php

$bookId = $_POST['bookId'];

include 'mysqlConnect.php';

$sql = "UPDATE books
	SET deleted = TRUE
	WHERE book_id = ".$bookId;

$result = $link->query($sql);

if($result == null) {
    echo "Something went wrong! Book could not be deleted.";
    exit();
} else {
	echo "success";
}