<?php

//TODO change to ajax call

checkFields();
addUser();
exit();

function addUser() {
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

    $user = $_REQUEST['username'];
    $pass = md5($_REQUEST['password']);
    $email = $_REQUEST['email'];
    $phone = str_replace("-", "", $_REQUEST['phone']);

    if($_REQUEST['librarian'] == 'on') {
        $librarian = 1;
    }
    else {
        $librarian = 0;
    }

    $firstName = $_REQUEST['firstName'];
    $lastName = $_REQUEST['lastName'];

    $sql = "INSERT INTO users (username, password, email, phone, librarian, first_name, last_name) 
            VALUES (\"$user\", \"$pass\", \"$email\", \"$phone\", $librarian, \"$firstName\", \"$lastName\")";

    if ($link->query($sql) === TRUE) {
        header("Location: ../login.html");
    } else {
        echo "Error: " . $sql . "<br>" . $link->error;
    }

    $link->close();
}


function checkFields() {
    $errors = [];

    if($_REQUEST['password'] != $_REQUEST['confirmPassword']) {
        array_push($errors, "Passwords do not match \n");
    }
    if($_REQUEST["username"] == "" || $_REQUEST['password'] == "" ||
        $_REQUEST["email"] == "" || $_REQUEST["firstName"] == "" ||
        $_REQUEST["lastName"] == "" ) {
        array_push($errors, "Fill in required fields\n");
    }
    if(!filter_var($_REQUEST['email'], FILTER_VALIDATE_EMAIL)) {
        array_push($errors, "Email is not valid\n");
    }
    if(preg_match("/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/", $_REQUEST['phone'])) {
    array_push($errors, "Phone number is not valid\n");
}
    if(ctype_alpha($_REQUEST['First name'])) {
        array_push($errors, "First name is not valid\n");
    }
    if(ctype_alpha($_REQUEST['Last name'])) {
        array_push($errors, "Last name is not valid\n");
    }

    if(count($errors) != 0) {
        for($i=0; $i<count($errors); $i++) {
            echo $errors[$i];
        }
        exit();
    }
}