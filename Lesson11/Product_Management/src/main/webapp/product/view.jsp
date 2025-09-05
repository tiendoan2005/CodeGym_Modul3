<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product</h1>
<p>
<a href="/products">Quay lại danh sách sản phẩm</a>
</p>
<table>
    <tr>
        <td>Name:</td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${requestScope["product".getPrice()]}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
    <tr>
        <td>NXB:</td>
        <td>${requestScope["product"].getNxb()}</td>
    </tr>
</table>
</body>
</html>
