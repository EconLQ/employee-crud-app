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
<dialog id="d">
    <form method="dialog">
        <p>Hi Mom! Check out my dialog!</p>
    </form>
    <button onclick="d.close()">Close</button>
</dialog>
<button onclick="d.showModal()">Open Dialog</button>
<p></p>
<c:forEach begin="1" end="10">
    <c:out value="cock"/>
    <br>
</c:forEach>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>