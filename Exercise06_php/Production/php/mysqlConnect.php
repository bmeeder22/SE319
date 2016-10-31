<?php

/******School*******/
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

/**********MAMP********/
//$user = 'root';
//$password = 'root';
//$db = 'Lab6';
//$host = '127.0.0.1';
//$port = 8889;
//
//$link = mysqli_init();
//$success = mysqli_real_connect(
//    $link,
//    $host,
//    $user,
//    $password,
//    $db,
//    $port
//);
