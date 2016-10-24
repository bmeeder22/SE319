<?php
/**
 * Created by PhpStorm.
 * User: benjaminmeeder
 * Date: 10/10/16
 * Time: 8:33 PM
 */

session_unset();
session_destroy();

header("Location: ../login.html");
exit();