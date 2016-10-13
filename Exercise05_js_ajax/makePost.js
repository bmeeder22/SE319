/**
 * Created by benjaminmeeder on 10/12/16.
 */
function handleMakePost() {
    $.post('makePost.php',
        {
            post: $('button').val()
        }
    );

    refresh();
}

function refresh() {
    $.get('viewPosts.php');
}