<?php
/**
 * Created by PhpStorm.
 * User: benjaminmeeder
 * Date: 10/10/16
 * Time: 8:32 PM
 */

$myfile = fopen("users.txt", "r");

$foundLine = getLine($myfile);

$array = explode(':', $foundLine);

$username = $array[0];
$password = $array[1];
$publickey = $array[2];
$privatekey = $array[3];

if(!checkPassword($password)) {
    sendError();
}

session_start();

$_SESSION['user'] = $array[0];
$_SESSION['pass'] = $array[1];
$_SESSION['publickey'] = $array[2];
$_SESSION['privatekey'] = $array[3];

echo json_encode($array);
exit();

function checkPassword($password) {
    if($password == $_POST['pass']) return true;
    return false;
}

function getLine($myfile) {
    $fileText = fread($myfile, filesize("users.txt"));

    $users = explode("&", $fileText);

    for($i = 0; $i<count($users); $i++) {
        if(substr($users[$i], 0, strlen($_POST['user'])) === $_POST['user'])  {
            return $users[$i];
        }
    }

    sendError();
}

function sendError() {
    echo "No user found for that combination";
    exit();
}