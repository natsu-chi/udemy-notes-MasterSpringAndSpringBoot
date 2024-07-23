<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
<div class="container">
    <div class="d-flex justify-content-end">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="./list">Todos</a></li>
                <li class="breadcrumb-item active" aria-current="page">Add</li>
            </ol>
        </nav>
    </div>

    <div class="row g-2">
        <div class="card">
            <div class="card-header">
                <a href="list" class="btn btn-sm btn-outline-dark">上一頁</a>
            </div>
            <div class="card-body">
                <div class="col-12">

                    <!-- html 寫法 -->
                    <!-- <form action="insert/v1" method="post">
                        <div class="row">
                            <div class="col">
                                <div class="mb-3 form-floating">
                                    <input type="text" class="form-control" name="d_title" id="d_title" value="${todo.title}" placeholder="字數 3~8" required="required" />
                                    <label for="d_title">Title</label>
                                    <div class="invalid-feedback">字數需介於 3-20 字</div>
                                </div>
                            </div>

                            <div class="col">
                                <div class="mb-3 form-floating">
                                    <input type="date" class="form-control" name="d_date" id="d_date" value="${todo.date}" placeholder="YYYY-MM-DD" required="required" />
                                    <label for="d_date">Date</label>
                                </div>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form> -->

                    <!-- 引入 Spring 表單標籤庫， 可以處理表單數據的綁定和驗證，減少手動寫 html 跟 js 的工作量 -->
                    <form:form method="post" action="insert/v2" modelAttribute="todo">
                        Title:
                        <form:input type="text" path="title" required="required" />
                        <form:errors path="title" cssClass="text-warning" />
                        <form:input type="date" path="date" />
                        <form:input type="hidden" path="id" />
                        <form:input type="hidden" path="done" />
                        <input type="submit" class="btn btn-light" />
                    </form:form>

                </div>
            </div>
        </div>
    </div>
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