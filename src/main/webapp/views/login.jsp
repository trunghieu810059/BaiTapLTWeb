<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>


<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body {
      background: #f5f7fa;
      font-family: Arial, sans-serif;
    }
    .login-container {
      width: 380px;
      margin: 80px auto;
      background: #fff;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0,0,0,0.1);
      padding: 30px;
    }
    .login-container h2 {
      text-align: center;
      margin-bottom: 20px;
      font-weight: bold;
      color: #333;
    }
    .form-group label {
      font-weight: 600;
    }
    .login-btn {
      width: 100%;
      background: #007bff;
      color: #fff;
      font-weight: bold;
      border: none;
      border-radius: 5px;
      padding: 10px;
      transition: 0.3s;
    }
    .login-btn:hover {
      background: #0056b3;
    }
    .form-check-label {
      font-size: 14px;
    }
    .alert {
      text-align: center;
      padding: 8px;
      margin-bottom: 15px;
    }
  </style>
</head>
<body>
<h1> </h1>
  <div class="login-container">
    <h2>Đăng nhập</h2>

    <!-- Thông báo lỗi -->
   
        <div class="alert alert-danger">${alert}</div>
    <p class="text-danger text-center">${requestScope.error}</p>
    
    <!-- Form login -->
    <form method="POST" action="login">
      <div class="form-group">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Nhập tên đăng nhập" required>
      </div>

      <div class="form-group">
        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required>
      </div>

      <div class="form-check mb-3">
        <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
        <label class="form-check-label" for="rememberMe">Nhớ tài khoản</label>
      </div>
      
      <button type="submit" class="login-btn">Đăng nhập</button>
    </form>
  </div>
</body>
</html>

