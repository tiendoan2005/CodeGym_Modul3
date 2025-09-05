<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Đăng ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5" style="max-width: 400px;">
    <h2 class="mb-4 text-center">Đăng ký tài khoản</h2>

    <form action="register" method="post">
        <div class="mb-3">
            <input type="text" name="username" class="form-control" placeholder="Tên đăng nhập" required>
        </div>
        <div class="mb-3">
            <input type="password" name="password" class="form-control" placeholder="Mật khẩu" required>
        </div>
        <div class="mb-3">
            <input type="email" name="email" class="form-control" placeholder="Email">
        </div>
        <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
    </form>

    <c:if test="${not empty error}">
        <p class="mt-3 text-danger text-center">${error}</p>
    </c:if>

    <p class="mt-3 text-center">
        Đã có tài khoản? <a href="login">Đăng nhập</a>
    </p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
