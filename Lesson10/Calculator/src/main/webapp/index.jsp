<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><strong>Simple Calculator</strong></h1>
<form action="calculator" method="post">
    <label for="num1">Number 1: </label>
    <input type="number" id="num1" name="num1"><br><br>
    <label>Operator: </label>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <br><br>
    <label for="num2">Number 2: </label>
    <input type="number" id="num2" name="num2">
    <br><br>
    <button type="submit">Calculator</button>
</form>
</body>
</html>