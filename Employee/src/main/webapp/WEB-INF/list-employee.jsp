<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<h1>Danh sách nhân viên</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>SĐT</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.email}</td>
            <td>${emp.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
