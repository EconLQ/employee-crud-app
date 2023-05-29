<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<c:forEach begin="1" end="10">
    <c:out value="cock"/>
    <br>
</c:forEach>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>