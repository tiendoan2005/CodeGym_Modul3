<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xóa phim</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center text-danger mb-4">Danh sách phim - Xác nhận xóa</h2>

    <table class="table table-striped table-bordered table-hover shadow-sm">
        <thead class="table-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Tiêu đề</th>
            <th scope="col">Thể loại</th>
            <th scope="col">Thời lượng</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="movie" items="${movieList}">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.genre}</td>
                <td>${movie.duration} phút</td>
                <td>${movie.description}</td>
                <td>
                    <form action="movies?action=delete" method="post"
                          onsubmit="return confirm('Bạn có chắc muốn xóa phim này không?');">
                        <input type="hidden" name="id" value="${movie.id}" />
                        <button type="submit" class="btn btn-sm btn-danger">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="movies" class="btn btn-secondary">⬅️ Quay lại danh sách</a>
    </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
