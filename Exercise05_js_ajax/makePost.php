<?php
session_start();

$file = file_get_contents('posts.txt');
$posts = convertJSONtoArray($file);
addPostToFile($posts);

function addPostToFile($posts) {
    $post = [
        'name' => $_SESSION['user'],
        'post' => $_POST['post'],
    ];

    array_push($posts, $post);
    $JSON = json_encode($posts);

    file_put_contents('posts.txt', $JSON);
}

function convertJSONtoArray($file) {
    $posts = json_decode($file);
    $user_posts = [];

    for($i = 0; $i<count($posts); $i++) {
        $postObject = $posts[$i];
        $post = get_object_vars($postObject);
        array_push($user_posts, $post);
    }

    return $user_posts;
}