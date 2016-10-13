/**
 * Created by benjaminmeeder on 10/12/16.
 */
function handleMakePost() {
    $.post('makePost.php',
        {
            post: $('#newpost').val()
        }
    );

    refresh();
}

function refresh() {
    location.reload();
}