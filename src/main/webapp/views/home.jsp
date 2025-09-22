<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
    <h1>Xin chào, ${sessionScope.account.username}!</h1>
    <p>Chúc mừng bạn đã đăng nhập thành công.</p>

    <!-- Chỉ admin mới thấy phần này -->
    <c:if test="${sessionScope.account.roleId == 1}">
        <h3>Quản lý hệ thống</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/admin/category/list">Quản lý Category</a></li>
        </ul>
    </c:if>

    <form action="${pageContext.request.contextPath}/logout" method="get">
        <button type="submit">Đăng xuất</button>
    </form>
</body>
</html>
