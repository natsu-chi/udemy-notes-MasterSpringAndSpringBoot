<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
<table class="table-rwd table table-hover table-light">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">name</th>
        <th scope="col">title</th>
        <th scope="col">date</th>
        <th scope="col">done</th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="data">
        <tr scope="row">
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>${data.title}</td>
            <td>${data.date}</td>
            <!-- boolean 要把 is 拿掉 (跟 JavaBean 的 getter/setter 方法有關) -->
            <td>${data.done}</td>
            <td><a href="./edit?id=${ data.id }">Edit</a></td>
            <td><a href="./delete?id=${ data.id }">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="./add">Add one</a>

<script src="../webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.6.0/jquery.min.js"></script>

<script>
    var u_id; // for update api

    $("#btn-update").click(function() {
        u_id = $(this).data("id");
        $("#d_title").val($(this).data("title"));
        $("#d_date").val($(this).data("date"));
        $("#d_done").prop("checked", $(this).data("done"));
    });

    $("#btn-update-save").click(function() {
        // 前端檢查更新行為 (先省略)
        var dataJSON = {};
        dataJSON["id"] = u_id;
        dataJSON["title"] = $("#d_title").val();
        dataJSON["date"] = $("#d_date").val();
        dataJSON["done"] = $("#d_done").is(":checked");
        console.log(JSON.stringify(dataJSON));
        // $.ajax({
        //     type: "POST",
        //     url: "/todo/update",
        //     data: JSON.stringify(dataJSON),
        //     contentType: "application/json;charset=utf-8",
        //     dataType: "json",
        //     success: showdata_update,
        //     error: function(e) {
        //         alert("error: " + e);
        //     }
        // })
    });

    function showdata_update(data) {
        // console.log(data);
        if(data.state) {
            window.location.reload();
        } else {
            alert(data.message + "Error");
        }
    }
</script>
</body>
</html>
