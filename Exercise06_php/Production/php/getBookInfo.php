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

$sql = "SELECT * FROM books WHERE book_id = \"".$bookId."\"";

$result = $link->query($sql);

if($result == null) {
    echo "Something went wrong! Book info not found.";
    exit();
}

$book = mysqli_fetch_assoc($result);
echo "book info: ";
var_dump($book);