<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><sitemesh:write property="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <!-- Header -->
    <div class="row">
        <%@ include file="/commons/admin/header.jsp"%>
    </div>
    <hr>

    <div class="row">
        <!-- Left menu -->
        <div class="col-3">
            <%@ include file="/commons/admin/left.jsp"%>
        </div>

        <!-- Main content -->
        <div class="col-9">
            <sitemesh:write property="body"/>
        </div>
    </div>
    <hr>

    <!-- Footer -->
    <div class="row">    
        <%@ include file="/commons/footer.jsp"%>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
