<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông báo</title>
    <script type="text/javascript">
        window.onload = function() {
            // Lấy message từ request attribute
            var msg = "<%= (request.getAttribute("message") != null) 
                          ? request.getAttribute("message") 
                          : "" %>";
            alert(msg);
            // Sau khi bấm OK thì chuyển sang trang login
            window.location.href = "<%= request.getContextPath() %>/login";
        }
    </script>
</head>
<body>
</body>
</html>
