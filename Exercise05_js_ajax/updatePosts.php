<?php
session_start();

$user_posts = $_SESSION['user_posts'];

function updatePostsFile($message, $postId) {
	global $user_posts;
	$user_posts[$postId]['post'] = $message;
	$JSON = json_encode($user_posts);
    file_put_contents('posts.txt', $JSON);
}

//If the user is 'admin' or the original poster
if($_SESSION['user'] === 'admin' || $_Session['user'] === $_POST['poster']) {
	updatePostsFile($_POST['message'], $_POST['postId']);
	echo true;
} else {
	echo false;
}