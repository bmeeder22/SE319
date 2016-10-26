<?php

session_start();

// echo "Session User : ";
// var_dump($_SESSION['user']);

echo json_encode($_SESSION['user']);