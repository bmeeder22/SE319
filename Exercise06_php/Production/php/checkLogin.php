<?php

session_unset();
session_destroy();

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

checkUser();

function checkUser() {
    global $link;

    $username = $_REQUEST['user'];
    $pass = md5($_REQUEST['pass']);

    $sql = "SELECT * FROM users WHERE username = \"$username\" AND password=\"$pass\"";

    $result = $link->query($sql);

    if($result == null) {
        echo "No user found with that combination";
        exit();
    }

    $user = mysqli_fetch_assoc($result);

    session_start();

    $_SESSION = $user;

    echo "success";
    exit();
}