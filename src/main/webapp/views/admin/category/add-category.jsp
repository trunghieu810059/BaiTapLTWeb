<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Category mới</h2>
    <form action="${pageContext.request.contextPath}/admin/category/add"
          method="post" enctype="multipart/form-data">
        
        <!-- Tên Category -->
        <div class="form-group">
            <label for="name">Tên Category:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        
        <!-- Upload ảnh -->
        <div class="form-group">
            <label for="icon">Chọn ảnh:</label>
            <input type="file" class="form-control-file" id="icon" name="icon" accept="image/*" required>
        </div>
        
        <button type="submit" class="btn btn-primary">Thêm Category</button>
        <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">Hủy</a>
    </form>
</div>
</body>
</html>
