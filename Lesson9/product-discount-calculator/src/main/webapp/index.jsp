<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="display-discount" method="post">
    <label for="description">Product Description</label>
    <input type="text" id="description" name="description" placeholder="Nhập mô tả: "><br><br>
    <label for="listPrice">List Price</label>
    <input type="number" id="listPrice" name="listPrice" placeholder="Giá niêm yết"><br><br>
    <label for="discountPercent">Discount Percent</label>
    <input type="number" id="discountPercent" name="discountPercent" placeholder="Tỷ lệ chiết khấu (phần trăm)"><br><br>
    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>
