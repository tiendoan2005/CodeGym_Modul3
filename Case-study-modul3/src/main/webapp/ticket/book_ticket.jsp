<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login");
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đặt vé - ${movie.title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h2 class="card-title mb-4 text-center">🎟️ Đặt vé xem phim</h2>

            <h4 class="mb-3 text-primary">${movie.title}</h4>

            <p><strong>Mô tả:</strong> ${movie.description}</p>
            <p><strong>Thể loại:</strong> ${movie.genre}</p>
            <p><strong>Thời lượng:</strong> ${movie.duration} phút</p>

            <form action="confirm-booking" method="post">
                <input type="hidden" name="userId" value="${sessionScope.user.id}" />
                <input type="hidden" name="movieId" value="${movie.id}" />

                <div class="mb-3">
                    <label class="form-label">Chọn ngày xem phim:</label>
                    <div class="d-flex flex-wrap gap-2">
                        <c:forEach var="date" items="${availableDates}">
                            <label class="btn btn-outline-primary">
                                <input type="radio" name="showDate" value="${date}" required> ${date}
                            </label>
                        </c:forEach>
                    </div>
                </div>


                <button type="submit" class="btn btn-success">Đặt vé</button>
                <a href="movies" class="btn btn-secondary">Quay lại</a>
            </form>
        </div>
    </div>
</div>

</body>
</html>
