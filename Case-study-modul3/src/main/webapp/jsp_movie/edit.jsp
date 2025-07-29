<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Sửa phim</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <h2 class="mb-4 text-center">✏️ Sửa thông tin phim</h2>

  <form action="movies?action=edit" method="post" class="border p-4 rounded bg-light shadow-sm">
    <input type="hidden" name="id" value="${movie.id}">

    <div class="mb-3">
      <label for="title" class="form-label">Tiêu đề</label>
      <input type="text" class="form-control" id="title" name="title" value="${movie.title}" required>
    </div>

    <div class="mb-3">
      <label for="genre" class="form-label">Thể loại</label>
      <input type="text" class="form-control" id="genre" name="genre" value="${movie.genre}" required>
    </div>

    <div class="mb-3">
      <label for="duration" class="form-label">Thời lượng</label>
      <input type="number" class="form-control" id="duration" name="duration" value="${movie.duration}" required>
    </div>

    <div class="mb-3">
      <label for="description" class="form-label">Mô tả</label>
      <input type="text" class="form-control" id="description" name="description" value="${movie.description}" required>
    </div>

    <div class="d-flex justify-content-between">
      <a href="movies" class="btn btn-secondary">⬅️ Quay lại</a>
      <button type="submit" class="btn btn-primary">💾 Cập nhật</button>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
