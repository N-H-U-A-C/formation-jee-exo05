<jsp:useBean id="dog" type="dev.cb.dogs.business.model.Dog" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dogs | Detail</title>
    <%@include file="../WEB-INF/imports/bootstrap.html" %>
</head>
<body>
<div class="container">
    <h1>- View a Dog -</h1>
    <br/>
    <form action="${pageContext.request.contextPath}/dog/list" method="get">
        <div class="mb-3">
            <label for="inputName" class="form-label">Name</label>
            <input type="text" class="form-control" id="inputName" name="inputName" value="<%=dog.getName()%>" readonly>
        </div>
        <div class="mb-3">
            <label for="inputBreed" class="form-label">Breed</label>
            <input type="text" class="form-control" id="inputBreed" name="inputBreed" value="<%=dog.getBreed()%>"
                   readonly>
        </div>
        <div class="mb-3">
            <label for="inputBirthDate" class="form-label">Birthdate</label>
            <input type="date" class="form-control" id="inputBirthDate" name="inputBirthDate"
                   value="<%=dog.getBirthDate()%>" readonly>
        </div>
        <button type="submit" class="btn btn-primary">Return</button>
    </form>
</div>
</body>
</html>
