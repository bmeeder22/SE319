<?php

include 'mysqlConnect.php';

$shelfs = [];

$sql = "SELECT * FROM books WHERE book_id in (SELECT book_id FROM shelves WHERE shelf_id = 1) AND deleted=FALSE;";
$result = $link->query($sql);
$shelves['art'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

$sql = "SELECT * FROM books WHERE book_id in (SELECT book_id FROM shelves WHERE shelf_id = 2) AND deleted=FALSE;";
$result = $link->query($sql);
$shelves['science'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

$sql = "SELECT * FROM books WHERE book_id in (SELECT book_id FROM shelves WHERE shelf_id = 3) AND deleted=FALSE;";
$result = $link->query($sql);
$shelves['sport'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

$sql = "SELECT * FROM books WHERE book_id in (SELECT book_id FROM shelves WHERE shelf_id = 4) AND deleted=FALSE;";
$result = $link->query($sql);
$shelves['literature'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

echo json_encode($shelves);