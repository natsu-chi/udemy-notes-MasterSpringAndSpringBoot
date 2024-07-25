<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User - list</title>
    <link href="../webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<div class="container">
    <table class="table-rwd table table-hover table-light">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">name</th>
            <th scope="col">birth date</th>
        </tr>
        </thead>
        <c:forEach items="${list}" var="data">
            <tr scope="row">
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.birthDate}</td>
                <td>${data.date}</td>
<%--                <td>--%>
                    <!-- Button trigger modal (Edit) -->
<%--                    <button--%>
<%--                            type="button"--%>
<%--                            id="btn-update"--%>
<%--                            class="btn btn-outline-dark"--%>
<%--                            data-bs-toggle="modal"--%>
<%--                            data-bs-target="#editModal"--%>
<%--                            data-id="${data.id}"--%>
<%--                            data-name="${data.name}"--%>
<%--                            data-title="${data.title}"--%>
<%--                            data-date="${data.date}"--%>
<%--                            data-done="${data.done}"--%>
<%--                    > <!-- data-bs-target 與 modal 的 id, aria-labelledby 須一致 -->--%>
<%--                        Edit--%>
<%--                    </button>--%>
                </td>
                <td><a href="./edit?id=${ data.id }">Edit</a></td>
                <td><a href="./delete?id=${ data.id }">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="../webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.6.0/jquery.min.js"></script>

<script>

    $("document").ready(function() {
        var flag_d_title = ($("#d_title").val().length >= 3 && $("#d_title").val().length <= 20);

        // #d_title 驗證: 字數 3-8 字
        $("#d_title").bind("input propertychange", function() {
            if($("#d_title").val().length >= 3 && $("#d_title").val().length <= 20) {
                // 符合規定
                $(this).removeClass("is-invalid");
                $(this).removeClass("is-valid");
            } else {
                // 不符合規定
                $(this).removeClass("is-valid");
                $(this).addClass("is-invalid");
                flag_d_title = true;
            }
        });

        $("form").on("submit", function(event) {
            event.preventDefault();
            if(flag_d_title) {
                // #d_date 驗證: 字數 3-8 字
                if($("#d_date").val() !== "") {
                    // 符合規定
                    this.submit();
                } else {
                    // 不符合規定
                    alert("請輸入日期");
                }
            }
        });
    });

</script>
</body>
</html>