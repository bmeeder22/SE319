<?php

$user = 'root';
$password = 'root';
$db = 'Lab6';
$host = 'localhost';
$port = 8889;

$link = mysqli_init();
$success = mysqli_real_connect(
    $link,
    $host,
    $user,
    $password,
    $db,
    $port
);

$shelfs = [];

$sql = "SELECT * FROM books WHERE shelf=1;";
$result = $link->query($sql);
$shelves['art'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

$sql = "SELECT * FROM books WHERE shelf=2;";
$result = $link->query($sql);
$shelves['science'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

$sql = "SELECT * FROM books WHERE shelf=3;";
$result = $link->query($sql);
$shelves['sport'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

$sql = "SELECT * FROM books WHERE shelf=4;";
$result = $link->query($sql);
$shelf =
$shelves['literature'] = mysqli_fetch_all($result, MYSQLI_ASSOC);

echo json_encode($shelves);