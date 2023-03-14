// blog
function loadMore(nextPage) {
    loadBlogs(nextPage, true);
}

function renderLoadMoreBtn (blogPageData) {
    if (blogPageData.number < blogPageData.totalPages -1) {
        $("#loadMoreContainer").html (
            `
                <button id="loadMoreId" type="button" class="btn btn-primary"
                onclick="loadMore(${blogPageData.number + 1})">
                Load More
                </button>
            `
        )
    } else {
        $("#loadMoreId").remove();
    }
}

function renderBlogs (blogs, append) {
    let elements = "";
    for (let blog of blogs) {
        elements += 
        `<tr>
        <td>${blog.authorName}</td>
        <td>${blog.title}</td>
        <td>${blog.categoryDTO.name}</td>
        </tr>`;
    }

    if (append) {
        $("#listBlogs").append(elements);
    } else {
        $("#listBlogs").html(elements);
    }
}

function loadBlogs(page, append) {
    let title = $("#title").val();
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog?page=${page ? page : "0"}&title=${title}`,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderBlogs(data.content, append);
            renderLoadMoreBtn(data);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

$(document).ready(function () {
    loadBlogs();
})



