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

 $user = $_SESSION['user'];
 $poster = $_POST['poster'];

if (strcmp($user, 'admin') == 0) { //USER IS ADMIN
	// echo "user is admin.";
	if ($_POST['delete']) { //ADMIN wants to delete the post
		deletePostFromFile($_POST['postId']);
		// echo "admin wants to delete post";
		echo true;
	} else {
		updatePostsFile($_POST['message'], $_POST['postId']);
		// echo "admin wants to update post";
		echo true;
	}
} else if (strcmp($user, $poster) == 0){ //USER IS THE ORIGINAL POSTER
	updatePostsFile($_POST['message'], $_POST['postId']);
	// echo "original user wants to update their post";
	echo true;
} else { //USER DOES NOT HAVE PERMISSION TO ACCESS THIS POST
	// echo "user does not have permission";
	echo false;
}