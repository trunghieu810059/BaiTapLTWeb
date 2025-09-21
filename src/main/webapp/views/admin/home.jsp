<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Xin chào, ${sessionScope.account.username}!</h1>
        <p>Chúc mừng bạn đã đăng nhập thành công.</p>

        <form action="${pageContext.request.contextPath}/logout" method="get">
            <button type="submit" class="btn btn-danger">Đăng xuất</button>
        </form>
    </div>
</body>
</html>
