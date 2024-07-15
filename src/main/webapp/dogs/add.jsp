<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dogs | Add</title>
    <%@include file="../WEB-INF/imports/bootstrap.html" %>
</head>
<body>
<main>
    <div class="container">
        <h1>- Add a Dog -</h1>
        <br/>
        <form action="${pageContext.request.contextPath}/dog/add" method="post">
            <div class="mb-3">
                <label for="inputName" class="form-label">Name</label>
                <input type="text" class="form-control" id="inputName" name="inputName">
            </div>
            <div class="mb-3">
                <label for="inputBreed" class="form-label">Breed</label>
                <input type="text" class="form-control" id="inputBreed" name="inputBreed">
            </div>
            <div class="mb-3">
                <label for="inputBirthDate" class="form-label">Birthdate</label>
                <input type="date" class="form-control" id="inputBirthDate" name="inputBirthDate">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
            <button type="reset" class="btn btn-primary">Reset</button>
        </form>
    </div>
</main>
</body>
</html>
