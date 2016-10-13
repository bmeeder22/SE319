<?php
$file = file_get_contents('posts.txt');
$user_posts = convertJSONtoArray($file);

function addPostToFile() {
    $post = $_REQUEST['post'];

    array_push($user_posts, $post);

    $JSON = json_encode($user_posts);
    
}

function convertJSONtoArray($file) {
    $posts = json_decode($file);
    $user_posts = [];

    for($i = 0; $i<count($posts); $i++) {
        $postObject = $posts[$i];
        $post = get_object_vars($postObject);
        array_push($user_posts, $post);

//      if you need to filter by username use this if statement
//      if($post['name'] == $_SESSION['user']) {
    }

    return $user_posts;
}