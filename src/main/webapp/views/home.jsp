<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<head>
    <title>Trang chủ</title>
</head>
<body>
    <h1>Xin chào, ${sessionScope.account.username}!</h1>

    <p>Chúc mừng bạn đã đăng nhập thành công.</p>

    <form action="${pageContext.request.contextPath}/logout" method="get">
        <button type="submit">Đăng xuất</button>
    </form>
</body>
<body>

</body>
</html>