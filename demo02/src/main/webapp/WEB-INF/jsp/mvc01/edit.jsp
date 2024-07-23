<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
        <div class="container">
            <!-- 引入 Spring 表單標籤庫， 可以處理表單數據的綁定和驗證，減少手動寫 html 跟 js 的工作量 -->
            <form:form method="post" action="update" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="title" required="required">Title: </form:label>
                    <form:input type="text" path="title" required="required" />
                    <form:errors path="title" cssClass="text-warning" />
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="date" required="required">Date: </form:label>
                    <form:input type="text" path="date" required="required" />
                    <form:errors path="date" cssClass="text-warning" />
                </fieldset>

                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="done" />
                <input type="submit" class="btn btn-light" />
            </form:form>
        </div>

        <script src="../webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="../webjars/jquery/3.6.0/jquery.min.js"></script>
        <script src="../webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

        <script type="text/javascript">
            $('#date').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>
    </body>
</html>