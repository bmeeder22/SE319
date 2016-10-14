<?php
session_start();

$file = file_get_contents('posts.txt');
$user_posts = convertJSONtoArray($file);

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

function renderTable() {
    renderTableTitle();
    renderPosts();
}

function renderTableTitle() {
    echo '<thead><tr><th class="text-left">By</th><th class="text-left">Post</th></tr></thead>';
}

function renderPosts() {
    global $user_posts;
    for($i = 0; $i<count($user_posts); $i++) {
        $post = $user_posts[$i];
        echo '<tr>';
        echo '<td onclick="">'.$post["name"].'</td>';
        echo '<td onclick="console.log(\'test\')">'.$post["post"].'</td>';
        echo '</tr>';
    }
}

?>

<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/viewPosts.css">
        <script src="js/makePost.js"></script>
    </head>
    <body>
        <div class="toolbar">
            <button onclick="window.location='sendMessage.php'">Send Message</button>
            <button onclick="window.location = 'inbox.php'">Inbox</button>
            <button onclick="window.location = 'logout.php'">Logout</button>
        </div>
        <table>
            <?php renderTable(); ?>
        </table>

        <br>

        <input id="newpost" type="text"/>
        <button onclick="handleMakePost();">Make a post!</button>

    </body>
</html>
