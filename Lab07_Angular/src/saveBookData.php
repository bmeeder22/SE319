<?php

$shelves = $_POST['shelves'];

#write data to bookdata.json
$fp = fopen('bookdata.json', 'w');
fwrite($fp, $shelves);
fclose($fp);

echo "success";