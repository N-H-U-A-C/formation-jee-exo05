<%@ page import="dev.cb.dogs.business.model.Dog" %>
<jsp:useBean id="dogs" type="java.util.ArrayList<dev.cb.dogs.business.model.Dog>" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dogs | List</title>
    <%@include file="../WEB-INF/imports/bootstrap.html" %>
</head>
<body>
<main>
    <div class="container">
        <h1>- Dogs List -</h1>
        <br/>
        <%if (!dogs.isEmpty()) {%>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Breed</th>
                <th scope="col">Birthdate</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%for (Dog dog : dogs) {%>
            <tr>
                <th scope="row"><%=dog.getId()%>
                </th>
                <td><%=dog.getName()%>
                </td>
                <td><%=dog.getBreed()%>
                </td>
                <td><%=dog.getBirthDate()%>
                </td>
                <td><a href="${pageContext.request.contextPath}/dog/detail?id=<%=dog.getId()%>" class="btn btn-primary">Detail</a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%} else {%>
        <p>Dogs list is empty!</p>
        <%}%>
        <br/>
        <a href="${pageContext.request.contextPath}/dog/add" class="btn btn-primary">Add a Dog</a>
    </div>
</main>
</body>
</html>
