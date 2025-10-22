<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>Header cua Admin</h1>
<div class="container">

    <!-- Welcome Section -->
    <div class="card shadow-sm welcome-box">
        <div class="card-body text-center">
            <h3 class="card-title text-primary">Xin chào, <b>${usernames}</b> 👋</h3>
            <p class="card-text text-muted">Chào mừng bạn đến với trang quản trị</p>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Đăng xuất</a>
        </div>
    </div>

    <!-- Các tuỳ chọn -->
    <div class="mt-4 text-center">
        <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-success btn-lg m-2">
            📂 Quản lý Category
        </a>
        <a href="${pageContext.request.contextPath}/admin/user/list" class="btn btn-primary btn-lg m-2">
            👤 Quản lý User
        </a>
        <a href="${pageContext.request.contextPath}/admin/product/list" class="btn btn-info btn-lg m-2">
            🛒 Quản lý Product
        </a>
    </div>

</div>