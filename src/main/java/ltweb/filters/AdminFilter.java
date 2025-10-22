package ltweb.filters;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ltweb.models.UserModel;

@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("✅ AdminFilter JDBC completed!");
    }

    @Override
    public void destroy() {
        System.out.println(" X AdminFilter JDBC destroyed!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        //  Kiểm tra đăng nhập
        if (session == null || session.getAttribute("account") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        //  Lấy user hiện tại
        UserModel user = (UserModel) session.getAttribute("account");

        //  Kiểm tra quyền (chỉ admin mới được vào /admin/*)
        if (user.getRoleid() != 1) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        // Nếu hợp lệ → cho phép đi tiếp
        chain.doFilter(request, response);
    }
}
