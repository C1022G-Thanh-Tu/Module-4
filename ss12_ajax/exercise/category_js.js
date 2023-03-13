function renderCategories (categories, append) {
    let elements = `
    <thead>
    <tr>
        <th>Tên thể loại</th>
        <th>List blog</th>
    </tr>
    </thead>
    <tbody>`;
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
    elements += "</tbody>";

    if (append) {
        $("#listCategories").append(elements);
    } else {
        $("#listCategories").html(elements);
    }
}

function loadCategorys(page, append) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/category?page=${page ? page : "0"}`,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderCategories(data.content)
        },
        error: function (error) {
            console.log(error);
        },
    });
}

$(document).ready(function () {
    loadCategorys();
})