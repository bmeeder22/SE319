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