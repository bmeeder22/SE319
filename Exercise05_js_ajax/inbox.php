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

//-----------------------END ExampleCryptography.php----------------------------

function convertFileToMessageArray($file, $private_key) {
    $messagesStringArray = explode('END-MESSAGE', $file); //create an array of the messages as strings
    $messageArray = [];

    foreach($messagesStringArray as &$fullMessageString) {
        //only check strings that are not empty
        if (strcmp($fullMessageString, '') != 0) {
            $messageStrings = explode('STRING-BREAK', $fullMessageString);
            
            $message = [
                receiver => $messageStrings[0],
                sender => $messageStrings[1],
                body => $messageStrings[2]
            ];
            //if the user is the recipient of the message, decrypt it and add it to the array
            if (strcmp($message['receiver'], $_SESSION['user']) == 0) {
                $message = decryptMessage($message, $private_key);
                array_push($messageArray, $message);
            }
        }
    }

    return $messageArray;
}

function decryptMessage($message, $private_key) {
    $newMessage = [
        receiver => $message['receiver'],
        sender => $message['sender'],
        body => rsa_decrypt($message['body'], $private_key)
    ];
    return $newMessage;
}

function renderTable() {
    renderTableTitle();
    renderMessages();
}

function renderTableTitle() {
    echo '<thead><tr><th class="text-left">From</th><th class="text-left">Message</th></tr></thead>';
}

function renderMessages() {
    global $messageArray;
    for($i = 0; $i<count($messageArray); $i++) {
        $message = $messageArray[$i];
        echo '<tr>';
        echo '<td>' . $message["sender"] . '</td>';
        echo '<td id="' . $i . '"onclick="">' . $message["body"] . '</td>';
        echo '</tr>';
    }
}
//---------------END FUNCTION DECLARATIONS-----------------


session_start();

//Get public and private keys
$private_key = $_SESSION['privatekey'];
$public_key = $_SESSION['publickey'];
//Get the contents of the file
$file = file_get_contents('messages.txt');
//Retrieve the user's messages and store them in an array
$messageArray = convertFileToMessageArray($file, $private_key);

?>

<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/viewPosts.css">
    </head>
    <body>
        <h1>Inbox</h1>
        <div class="toolbar">
        	<button onclick="window.location = 'sendMessage.php'">Send Message</button>
            <button onclick="window.location = 'viewPosts.php'">View Posts</button>
            <button onclick="window.location = 'logout.php'">Logout</button>
        </div>
        <table id="inbox">
            <?php renderTable(); ?>
        </table>

    </body>
</html>