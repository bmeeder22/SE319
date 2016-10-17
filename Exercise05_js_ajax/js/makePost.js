/**
 * Created by benjaminmeeder on 10/12/16.
 */

function handleMakePost() {
	$.post('makePost.php',
	    {
	        post: $('#newpost').val()
	    }
	);

	$("#postsTable").load(location.href + " #postsTable"); // refresh the table
	$("#submitNewPost").load(location.href + " #submitNewPost"); // refresh the table
}