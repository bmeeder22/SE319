<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Signup!</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
    <h6>Signup</h6>
    <form method="post" action="signup.html.php">
    <h4>Username</h4>
        <input id="username" type="text" name="user"/>
        <h4>Password</h4>
        <input id="password" type="text" name="pass"/>
        <input type="submit" name="submit">
    </form>

    <?php
        $path = 'phpseclib';
        set_include_path(get_include_path() . PATH_SEPARATOR . $path);
        include_once('phpseclib/Crypt/RSA.php');

        function signup() {
            echo "hello ".$_POST['user'];
            $myfile = fopen("users.txt", "a");

            $rsa = new Crypt_RSA();
            $rsa->setPrivateKeyFormat(CRYPT_RSA_PRIVATE_FORMAT_PKCS1);
            $rsa->setPublicKeyFormat(CRYPT_RSA_PUBLIC_FORMAT_PKCS1);

            $array = $rsa->createKey(1024);

            $privateKey = $array['privatekey'];
            $publicKey = $array['publickey'];

            echo $privateKey;
            echo $publicKey;

            $txt = $_POST['user'].':'.$_POST['pass'].':'.$publicKey.':'.$privateKey."&";

            fwrite($myfile, $txt);
            fclose($myfile);

            echo '<script>window.location="login.html"</script>';
        }

        if(isset($_POST['submit'])) {
           signup();
        }
    ?>
</body>
</html>