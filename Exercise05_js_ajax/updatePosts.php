<?php
session_start();

$user_posts = $_SESSION['user_posts'];

function updatePostsFile($message, $postId) {
	global $user_posts;
	$user_posts[$postId]['post'] = $message;
	$JSON = json_encode($user_posts);
    file_put_contents('posts.txt', $JSON);
}

function deletePostFromFile($postId) {
	global $user_posts;
	$user_posts[$postId] = NULL;
	unset($user_posts[$postId]);
	$JSON = json_encode($user_posts);
    file_put_contents('posts.txt', $JSON);
}

// echo "USER: ";
// echo $_SESSION['user'];
// echo "POSTER: ";
// echo $_POST['poster'];
// echo "user == poster: ";
//
 $user = $_SESSION['user'];
 $poster = $_POST['poster'];
// if (strcmp($user,$poster)) {
// 	echo "true";
// } else {
// 	echo "false";
// }

if ($user === 'admin' or $user === $poster) {
	if ($_POST['delete'] && $user === 'admin') {
		deletePostFromFile($_POST['postId']);
		echo true;
	} else if (!$_POST['delete']) {
		updatePostsFile($_POST['message'], $_POST['postId']);
		echo true;
	} else {
		echo false;
	}
} else {
	echo false;
}