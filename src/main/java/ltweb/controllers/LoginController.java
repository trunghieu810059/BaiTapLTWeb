package ltweb.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ltweb.services.UserService;
import ltweb.services.Impl.UserServiceImpl;
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService service = new UserServiceImpl();
        var user = service.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", user); // 🔥 Quan trọng

            // Nếu admin → chuyển admin home
            if (user.getRoleid() == 1) {
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else {
                // user thường → về home
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            req.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
        }
    }

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
		resp.sendRedirect(req.getContextPath()+ "/waiting");
		return;
	}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath()+ "/waiting");
					return;
	}
	

	} } 
	req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	}
	
	

	

