<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
</head>

<body>
    <form action="/login" method="post">
        <pre>${ errorMessage }</pre>
        <label for="name">ID: </label>
        <input type="text" name="name" id="name" />
        
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" />

        <input type="submit" value="Submit" />
    </form>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>