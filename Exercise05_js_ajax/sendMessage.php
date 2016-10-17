<?php
session_start();

?>

<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/viewPosts.css">
    </head>
    <body>
        <div class="toolbar">
        	<button onclick="window.location = 'viewPosts.php'">View Posts</button>
            <button onclick="window.location = 'inbox.php'">Inbox</button>
            <button onclick="window.location = 'logout.php'">Logout</button>
        </div>

        <br>
        <form action="makeMessage.php">
    		<input name="reciever" type="text" placeholder="To: "><br>
            <input name="body" type="text" placeholder="Enter your message..."><br>
            <input type="submit"/>
        </form>

    </body>
</html>