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

$sql = "SELECT username, A.book_id, due_date, returned_date, book_title, author
	FROM
	(SELECT *
	FROM loan_history) AS A
	JOIN
	(SELECT *
	FROM books) AS B
	ON A.book_id = B.book_id
	ORDER BY due_date DESC";

$result = $link->query($sql);

$history = mysqli_fetch_all($result, MYSQLI_ASSOC);

echo json_encode($history);