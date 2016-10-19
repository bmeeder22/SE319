<?php

//-----------------------FROM ExampleCryptography.php----------------------------
$path = 'phpseclib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
include_once('phpseclib/Crypt/RSA.php');

//Function for encrypting with RSA
function rsa_encrypt($string, $public_key)
{
    //Create an instance of the RSA cypher and load the key into it
    $cipher = new Crypt_RSA();
    $cipher->loadKey($public_key);
    //Set the encryption mode
    $cipher->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
    //Return the encrypted version
    return $cipher->encrypt($string);
}

//-----------------------END ExampleCryptography.php----------------------------

function getUserPublicKey($username) {
    global $users;
    foreach ($users as $user) {
        if (strcmp($user['username'], $username) == 0) {
            return $user['publickey'];
        }
    }
    return "USER NOT FOUND";
}

function getUsersArray($file) {
    $users = [];
    $fullUserStrings = explode("&", $file);

    foreach ($fullUserStrings as &$userString) {
        //check if string is empty
        if (strcmp($userString, '') != 0) {
            $userInfo = explode(":", $userString);

            $user = [
                username => $userInfo[0],
                publickey => $userInfo[2]
            ];
            array_push($users, $user); //add username and public key to array
        }
    }
    return $users;
}

//----------------------END FUNCTION DECLARATIONS-----------------------

session_start();

$usersFile = file_get_contents('users.txt');
$users = getUsersArray($usersFile);

$public_key = getUserPublicKey($_GET['receiver']);

if (strcmp($public_key, "USER NOT FOUND") == 0) {
    echo "No user found by that name.";
    exit();
}

$file = file_get_contents('messages.txt'); //retrieve contents of file

$encryptedText = rsa_encrypt($_GET['body'], $public_key); //encrypt the body of the message
//construct string to be saved
$txt = $_GET['receiver'].'STRING-BREAK'.$_SESSION['user'].'STRING-BREAK'.$encryptedText."END-MESSAGE";

$newFile = $file.$txt; //add new message to existing messages

file_put_contents("messages.txt", $newFile); //save all messages back to the file



?>

<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/viewPosts.css">
    </head>
    <body>
        <div class="toolbar">
            <button onclick="window.location = 'sendMessage.php'">Send Message</button>
            <button onclick="window.location = 'inbox.php'">Inbox</button>
            <button onclick="window.location = 'viewPosts.php'">View Posts</button>
            <button onclick="window.location = 'logout.php'">Logout</button>
        </div>

        <br>
        <h2>Message Sent!</h2>

    </body>
</html>