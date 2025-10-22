<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body class="container">

    <h2 class="mt-4">Sửa Category</h2>
    <form action="${pageContext.request.contextPath}/admin/category/edit" 
          method="post" enctype="multipart/form-data" class="form">
        
        <!-- ID ẩn -->
        <input type="hidden" name="id" value="${category.id}"/>
        
        <!-- Tên -->
        <div class="form-group">
            <label for="name">Tên Category:</label>
            <input type="text" class="form-control" id="name" name="name" 
                   value="${category.name}" required/>
        </div>
        
        <!-- Icon hiện tại -->
        <div class="form-group">
            <label>Icon hiện tại:</label><br/>
            <c:if test="${not empty category.icon}">
                <img src="${pageContext.request.contextPath}/${category.icon}" 
                     width="80" class="img-thumbnail"/>
            </c:if>
        </div>
        
        <!-- Upload icon mới -->
        <div class="form-group">
            <label for="icon">Đổi Icon (nếu cần):</label>
            <input type="file" id="icon" name="icon" class="form-control-file" accept="image/*"/>
        </div>
        
        <!-- Buttons -->
        <button type="submit" class="btn btn-primary">Cập nhật</button>
        <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">Quay lại</a>
    </form>

</body>
</html>
