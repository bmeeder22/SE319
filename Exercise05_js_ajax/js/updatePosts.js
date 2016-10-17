function handleUpdatePost(id, name) {
	// Select post prompt
	var message = window.prompt("Enter the new message: ");

	$.post( "updatePosts.php",
		{
			postId: id,
			poster: name,
			message: message
		},
		function(postChanged) {
			if (postChanged) {
				alert("Post updated!");
				$("#postsTable").load(location.href + " #postsTable"); // refresh the table
			} else {
				alert("You don't have permission to edit that post.");
			}
		});
}