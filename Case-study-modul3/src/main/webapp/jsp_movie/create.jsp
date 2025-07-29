<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm phim mới</title>

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }

        .form-container {
            max-width: 600px;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
        }
    </style>
</head>
<body>

<div class="container">
    <div class="form-container">
        <h2 class="text-center mb-4">🎬 Thêm phim mới</h2>
        <form action="movies?action=create" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">Tiêu đề phim</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="Nhập tiêu đề" required>
            </div>
            <div class="mb-3">
                <label for="genre" class="form-label">Thể loại</label>
                <input type="text" class="form-control" id="genre" name="genre" placeholder="Ví dụ: Hành động, Hài..."
                       required>
            </div>
            <div class="mb-3">
                <label for="time" class="form-label">Thời lương</label>
                <input type="number" class="form-control" id="time" name="duration" required>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Mô tả</label>
                <input type="text" class="form-control" id="description" name="description" required>
            </div>
            <div class="mb-3">
                <label for="startDate" class="form-label">Ngày bắt đầu đặt vé</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="mb-3">
                <label for="endDate" class="form-label">Ngày kết thúc đặt vé</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">➕ Thêm phim</button>
            </div>
        </form>

        <div class="text-center mt-3">
            <a href="movies" class="btn btn-secondary">⬅️ Quay lại danh sách</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS (tuỳ chọn) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
