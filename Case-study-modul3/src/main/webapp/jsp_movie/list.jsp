<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang chủ - Quản lý phim</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        html, body {
            height: 100%;
            margin: 0;
            display: flex;
            flex-direction: column;
            background-color: #f8f9fa;
        }
        body { padding-top: 100px; }
        .fixed-header {
            position: fixed; top: 0; left: 0; right: 0; z-index: 1030;
            background-color: #343a40; color: white;
            box-shadow: 0 2px 6px rgba(0,0,0,0.2);
        }
        .navbar-nav .nav-link { color: white !important; font-weight: 500; }
        .movie-card {
            flex: 1; display: flex; flex-direction: column; justify-content: space-between;
            border: none; border-radius: 15px; padding: 20px; margin-bottom: 30px;
            background-color: #ffffff; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s ease-in-out;
        }
        .movie-card:hover { transform: scale(1.02); }
        .movie-title { font-weight: bold; font-size: 22px; color: #343a40; }
        main { flex: 1; }
        .footer { background-color: #343a40; color: white; text-align: center; padding: 15px 0; margin-top: auto; }
        .carousel img { height: 400px; object-fit: cover; border-radius: 10px; }
        .row { display: flex; flex-wrap: wrap; }
        .col-md-4 { display: flex; }
        .nav-underline-custom { gap: 30px; }
        .nav-link-custom {
            position: relative; font-size: 1.3rem; font-weight: 600; color: #343a40;
            text-decoration: none; padding-bottom: 5px; transition: color 0.3s ease-in-out;
        }
        .nav-link-custom::after {
            content: ""; position: absolute; left: 0; bottom: 0; height: 3px; width: 0;
            background-color: #0d6efd; transition: width 0.3s ease-in-out;
        }
        .nav-link-custom:hover { color: #0d6efd; }
        .nav-link-custom:hover::after { width: 100%; }
        .nav-link-custom.active { color: #0d6efd; }
        .nav-link-custom.active::after { width: 100%; }
    </style>
</head>
<body>
<header class="fixed-header">
    <div class="container py-3 d-flex justify-content-between align-items-center">
        <h1 class="h5 mb-0">
            <a href="movies?action=list" class="text-white text-decoration-none">🎬 Hệ thống quản lý phim</a>
        </h1>

        <form action="movies" method="post" class="d-flex" style="max-width: 300px;">
            <input type="hidden" name="action" value="find">
            <input class="form-control me-2" type="search" name="keyword" placeholder="Tìm kiếm phim..." aria-label="Search">
            <button class="btn btn-outline-light" type="submit">🔍</button>
        </form>

        <nav>
            <ul class="nav">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <li class="nav-item">
                            <a class="nav-link fw-bold text-warning" href="#">👤 ${sessionScope.user.username}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Đăng xuất</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="login">Đăng nhập</a></li>
                        <li class="nav-item"><a class="nav-link" href="register">Đăng ký</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </div>
</header>

<main class="container py-4">
    <c:if test="${not empty message}">
        <div class="alert alert-warning text-center">${message}</div>
    </c:if>

    <div id="carouselExampleIndicators" class="carousel slide mb-4" data-bs-ride="carousel">
        <div class="carousel-inner rounded-3 overflow-hidden">
            <div class="carousel-item active">
                <img src="images/movie1.jpg" class="d-block w-100" alt="Slide 1">
            </div>
            <div class="carousel-item">
                <img src="images/movie2.jpg" class="d-block w-100" alt="Slide 2">
            </div>
            <div class="carousel-item">
                <img src="images/movie3.jpg" class="d-block w-100" alt="Slide 3">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <div class="d-flex justify-content-center mb-4 nav nav-underline-custom">
        <a href="#" class="nav-link-custom">Phim sắp chiếu</a>
        <a href="#" class="nav-link-custom active">Phim đang chiếu</a>
        <a href="#" class="nav-link-custom">Suất chiếu đặc biệt</a>
    </div>

    <div class="row">
        <c:forEach var="movie" items="${movieList}">
            <div class="col-md-4">
                <div class="movie-card">
                    <div>
                        <div class="movie-title">${movie.title}</div>
                        <div><strong>Thể loại:</strong> ${movie.genre}</div>
                        <div><strong>Thời lượng:</strong> ${movie.duration} phút</div>
                    </div>
                    <div class="mt-3 text-end">
                        <a href="book-ticket?movieId=${movie.id}" class="btn btn-primary">🎟️ Đặt vé</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</main>

<footer class="footer">
    <div class="container">
        <p class="mb-0">2025 Hệ thống quản lý phim.</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.querySelectorAll('.nav-link-custom').forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            document.querySelectorAll('.nav-link-custom').forEach(el => el.classList.remove('active'));
            this.classList.add('active');
        });
    });
</script>
</body>
</html>
