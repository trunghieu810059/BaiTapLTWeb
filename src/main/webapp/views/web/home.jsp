<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Home</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="container text-center mt-5">

    <h2>Chào mừng đến với hệ thống</h2>
    <p>Vui lòng chọn đăng nhập hoặc đăng ký để tiếp tục.</p>

    <div class="row justify-content-center mt-4">
        <!-- Nút đăng nhập -->
        <div class="col-4">
            <a href="${pageContext.request.contextPath}/login" 
               class="btn btn-primary w-100">Đăng nhập</a>
        </div>

        <!-- Nút đăng ký -->
        <div class="col-4">
            <a href="${pageContext.request.contextPath}/register" 
               class="btn btn-success w-100">Đăng ký</a>
        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
