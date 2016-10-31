<?php

include 'mysqlConnect.php';

$bookId = $_POST['bookId'];

$sql = "SELECT *
FROM loan_history
INNER JOIN books
ON loan_history.book_id=books.book_id
WHERE loan_history.book_id=" . $bookId;

$result = $link->query($sql);

$history = mysqli_fetch_all($result, MYSQLI_ASSOC);

echo json_encode($history);