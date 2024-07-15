<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Welcome to wouaf app!" %></h1>
<br/>
<a href="${pageContext.request.contextPath}/dog/list">View all dogs</a>
</body>
</html>