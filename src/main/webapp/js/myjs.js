function doLike(post_id, liker)
{
    console.log(post_id + "," + liker)
    const d = {
        liker: liker,
        post_id: post_id,
        operation: 'like'
    }

    $.ajax({
        url: "Like",
        data: d,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if (data.trim() == 'true')
            {
                let c = $(".like-counter").html();
                c++;
                $('.like-counter').html(c);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(data)
        }
    })
}