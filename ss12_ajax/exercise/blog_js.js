// blog
function loadMore(nextPage) {
    loadBlogs(nextPage, true);
}

function renderLoadMoreBtn (blogPageData) {
    if (blogPageData.number < blogPageData.totalPages -1) {
        $("#loadMoreContainer").html (
            `
                <button type="button" class="btn btn-primary"
                onclick="loadMore(${blogPageData.number + 1})">
                Load More
                </button>
            `
        )
    } else {
        $("#loadMoreContainer").remove();
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
    let title = document.getElementById("title").value;
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


// caterogry
function loadMoreCategory(nextPage) {
    loadCategories(nextPage, true);
}

function renderLoadMoreCategoryBtn (categoryPageData) {
    if (categoryPageData.number < categoryPageData.totalPages -1) {
        $("#loadMoreCategoryContainer").html (
            `
                <button type="button" class="btn btn-primary"
                onclick="loadMoreCategory(${categoryPageData.number + 1})">
                Load More
                </button>
            `
        )
    } else {
        $("#loadMoreCategoryContainer").remove();
    }
}

function renderCategories (categories, append) {
    let elements = "";
    for (let category of categories) {
        elements += 
        `<tr>
        <td>${category.name}</td>
        <td>` 
        for (let blogDTO of category.blogDTOSet) {
         elements += 
         blogDTO.title + `<br>`
        }
        `</td>
        </tr>`;
    }

    if (append) {
        $("#listCategories").append(elements);
    } else {
        $("#listCategories").html(elements);
    }
}

function loadCategories(page, append) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/category?page=${page ? page : "0"}`,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderCategories(data.content, append)
            renderLoadMoreCategoryBtn(data)
        },
        error: function (error) {
            console.log(error);
        },
    });
}

$(document).ready(function () {
    loadCategories();
})
