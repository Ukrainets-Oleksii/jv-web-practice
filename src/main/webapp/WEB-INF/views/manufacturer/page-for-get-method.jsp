<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get driver</title>
</head>
<body>
<h1>Manufacturer</h1>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Country</td>
    </tr>
    <tr>
        <td><c:out value="${manufacturer.id}" /></td>
        <td><c:out value="${manufacturer.name}" /></td>
        <td><c:out value="${manufacturer.country}" /></td>
    </tr>
</table>
</body>
</html>
