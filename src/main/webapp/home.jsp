<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Trang Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="container text-center mt-5">

    <h2>Chào mừng đến với hệ thống</h2>

    <c:choose>
        <!-- Nếu chưa đăng nhập -->
        <c:when test="${empty sessionScope.account}">
            <p>Vui lòng chọn đăng nhập hoặc đăng ký để tiếp tục.</p>
            <div class="row justify-content-center mt-4">
                <div class="col-4">
                    <a href="${pageContext.request.contextPath}/views/login" class="btn btn-primary w-100">Đăng nhập</a>
                </div>
                <div class="col-4">
                    <a href="${pageContext.request.contextPath}/register" class="btn btn-success w-100">Đăng ký</a>
                </div>
            </div>
        </c:when>

        <!-- Nếu đã đăng nhập -->
        <c:otherwise>
            <p>Xin chào, <b>${sessionScope.account.fullname}</b>!</p>
            <p>Email: ${sessionScope.account.email}</p>

            <div class="mt-4">
                <c:if test="${sessionScope.account.roleId == 1}">
                    <!-- Admin menu -->
                    <a href="${pageContext.request.contextPath}/admin/home" class="btn btn-warning">Trang quản trị</a>
                </c:if>

                <!-- User menu -->
                <a href="${pageContext.request.contextPath}/profile" class="btn btn-info">Thông tin cá nhân</a>
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Đăng xuất</a>
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
