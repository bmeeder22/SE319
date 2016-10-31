<?php
include 'mysqlConnect.php';

$bookId = $_POST['bookId'];

$sql = "SELECT * FROM books WHERE book_id=" . $bookId;

$result = $link->query($sql);

if($result == null) {
    echo "Something went wrong! Book info not found.";
    exit();
}

$book = mysqli_fetch_assoc($result);

if($book['availability'] == 0){
    $sql = "SELECT books.*, loan_history.username
    FROM books
    INNER JOIN loan_history
    ON books.book_id=loan_history.book_id
    WHERE loan_history.returned_date IS NULL AND books.book_id=" . $bookId;

    $result = $link->query($sql);

    if($result == null) {
        echo "Something went wrong! Book info not found.";
        exit();
    }

    $book = mysqli_fetch_assoc($result);
}

echo json_encode($book);