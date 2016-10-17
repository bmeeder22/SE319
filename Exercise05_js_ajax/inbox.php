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

session_start();

//if ($_SESSION['user'] == 'neig') {
//    echo "true";
//} else {
//    echo "false";
//}

//Get public and private keys
$private_key = $_SESSION['privatekey'];
$public_key = $_SESSION['publickey'];

$file = file_get_contents('messages.txt');

$decipheredtext = rsa_decrypt($file, $private_key);

//echo $decipheredtext;

$messageArray = convertJSONtoArray($decipheredtext);

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
//        var_dump($message);
//        echo "Receiver: ";
//        echo $message['receiver'];
//        echo "User: ";
//        echo $message['user'];
        if ($message['receiver'] === $_SESSION['user']) {
            echo '<tr>';
            echo '<td>' . $message["sender"] . '</td>';
            echo '<td id="' . $i . '"onclick="">' . $message["body"] . '</td>';
            echo '</tr>';
        }
    }
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
            <button onclick="window.location = 'viewPosts.php'">View Posts</button>
            <button onclick="window.location = 'logout.php'">Logout</button>
        </div>
        <table id="inbox">
            <?php renderTable(); ?>
        </table>

    </body>
</html>