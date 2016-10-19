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

//Function for decrypting with RSA 
function rsa_decrypt($string, $private_key)
{
    //Create an instance of the RSA cypher and load the key into it
    $cipher = new Crypt_RSA();
    $cipher->loadKey($private_key);
    //Set the encryption mode
    $cipher->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
    //Return the decrypted version
    return $cipher->decrypt($string);
}

//Test out the rsa encryption functions
// $plaintext = "This is some plaintext to encrypt";
// $ciphertext = rsa_encrypt($plaintext, $public_key);
// $decipheredtext = rsa_decrypt($ciphertext, $private_key);

//-----------------------END ExampleCryptography.php----------------------------

session_start();

//Get public and private keys
$private_key = $_SESSION['privatekey'];
$public_key = $_SESSION['publickey'];

$file = file_get_contents('messages.txt'); //retrieve contents of file in JSON format

$encryptedMessages = convertJSONtoArray($file); //transform JSON into an array of message objects

addMessageToFile($encryptedMessages, $public_key);

function addMessageToFile($messages, $public_key) {
    // $myfile = fopen("messages.txt", "a");
    global $file;
    $encryptedText = rsa_encrypt($_GET['body'], $public_key);

    $txt = $_GET['receiver'].'STRING-BREAK'.$_SESSION['user'].'STRING-BREAK'.$encryptedText."END-MESSAGE";

    $newFile = $file.$txt;

    file_put_contents("messages.txt", $newFile);
    // fclose($myfile);

    // $message = [
    //     'receiver' => $_GET['receiver'],
    //     'sender' => $_SESSION['user'],
    //     'body' => $encryptedText
    // ];

    // array_push($messages, $message); //add encrypted message to the array of message objects
    // echo "Messages: ";
    // echo "<br>";
    // echo "<br>";
    // echo "<br>";
    // var_dump($messages);
    // $JSON = json_encode($messages); //convert array of message objects back to JSON

    // echo $JSON;

    // file_put_contents('messages.txt', $JSON); //save JSON to file
}

function convertJSONtoArray($string) {
    $messages = json_decode($string);
    $messageArray = [];

    for($i = 0; $i<count($messages); $i++) {
        $messageObject = $messages[$i];
        $message = get_object_vars($messageObject);
        array_push($messageArray, $message);
    }

    return $messageArray;
}
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