<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Category</title>
</head>
<body>
    <h2>Sửa Category</h2>
    <form action="${pageContext.request.contextPath}/admin/category/edit" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${category.id}"/>
        
        <label>Tên Category:</label><br/>
        <input type="text" name="name" value="${category.name}" required/><br/><br/>
        
        <label>Icon hiện tại:</label><br/>
        <img src="${pageContext.request.contextPath}/${category.icon}" width="60"/><br/><br/>
        
        <label>Đổi Icon (nếu cần):</label><br/>
        <input type="file" name="icon"/><br/><br/>
        
        <button type="submit">Cập nhật</button>
        <a href="${pageContext.request.contextPath}/admin/category/list">Quay lại</a>
    </form>
</body>
</html>
