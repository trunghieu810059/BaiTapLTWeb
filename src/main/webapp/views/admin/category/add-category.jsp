<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Category</title>
</head>
<body>
    <h2>Thêm Category</h2>
    <form action="${pageContext.request.contextPath}/admin/category/add" method="post" enctype="multipart/form-data">
        <label>Tên Category:</label><br/>
        <input type="text" name="name" required/><br/><br/>

        <label>Icon:</label><br/>
        <input type="file" name="icon"/><br/><br/>

        <button type="submit">Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/category/list">Quay lại</a>
    </form>
</body>
</html>
