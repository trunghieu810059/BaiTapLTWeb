<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	background: #f8f9fa;
}

h2 {
	margin: 20px 0;
}

.table thead th {
	text-align: center;
	background: #343a40;
	color: white;
	vertical-align: middle;
}

.table td {
	text-align: center;
	vertical-align: middle;
}

.table img {
	max-width: 60px;
	max-height: 60px;
	border-radius: 8px;
	border: 1px solid #ddd;
	background: #fff;
	padding: 3px;
	object-fit: cover; 
}

.btn-action {
	margin: 0 3px;
}
</style>
</head>
<body class="container">

	<h2>📂 Danh sách Category</h2>

	<p>
		<a href="${pageContext.request.contextPath}/admin/category/add"
			class="btn btn-success"> + Thêm Category </a>
	</p>

	<div class="table-responsive">
		<table class="table table-bordered table-hover shadow-sm">
			<thead>
				<tr>
					<th style="width: 10%;">ID</th>
					<th style="width: 25%;">Tên</th>
					<th style="width: 25%;">Hình ảnh</th>
					<th style="width: 25%;">Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${cateList}">
					<tr>
						<td>${c.id}</td>
						<td>${c.name}</td>
						<td><c:if test="${not empty c.icon}">
								<img src="${pageContext.request.contextPath}/${c.icon}"
									alt="icon" />
							</c:if></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/category/edit?id=${c.id}"
							class="btn btn-primary btn-sm btn-action">✏️ Sửa</a> <a
							href="${pageContext.request.contextPath}/admin/category/delete?id=${c.id}"
							class="btn btn-danger btn-sm btn-action"
							onclick="return confirm('Bạn có chắc muốn xoá hình ảnh này?');">🗑
								Xoá</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
