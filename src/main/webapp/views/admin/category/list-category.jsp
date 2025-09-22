<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body class="container">

    <h2>Danh sách Category</h2>

    <p>
        <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-success">
            + Thêm Category
        </a>
    </p>

    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Icon</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${categories}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>
                        <c:if test="${not empty c.icon}">
                            <img src="${pageContext.request.contextPath}/${c.icon}" width="80" height="80"/>
                        </c:if>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/category/edit?id=${c.id}" class="btn btn-primary btn-sm">
                            Sửa
                        </a>
                        <a href="${pageContext.request.contextPath}/admin/category/delete?id=${c.id}" 
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Bạn có chắc muốn xoá?');">
                            Xoá
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
