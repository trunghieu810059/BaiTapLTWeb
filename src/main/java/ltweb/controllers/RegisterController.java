package ltweb.controllers;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ltweb.services.UserService;
import ltweb.services.Impl.UserServiceImpl;

@WebServlet(urlPatterns = "/register")
@SuppressWarnings("serial")

public class RegisterController extends HttpServlet {
	private String avatar;

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username")
			!= null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}
		//Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/admin");
					return;
				}
			}
		}
		
		req.getRequestDispatcher("views/register.jsp").forward(req, resp);
		
	}
	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse
	resp) throws ServletException, IOException {
		
		
		try {
		
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String avatar = req.getParameter("avatar");
		
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		
		String roleIdString = req.getParameter("roleid"); 
		int roleid = Integer.parseInt(roleIdString); 
		
		UserService service = new UserServiceImpl();
		String alertMsg = "";



		
			if (service.checkExistEmail(email)) {
				alertMsg = "Email đã tồn tại!";
				req.setAttribute("alert", alertMsg);
				
				String urlRegister = "/register";
				req.getRequestDispatcher(urlRegister).forward(req,resp);
				
				
				return;
			}
			if (service.checkExistUsername(username)) {
				alertMsg = "Tài khoản đã tồn tại!";
				req.setAttribute("alert", alertMsg);
				
				String urlRegister = "/register";
				req.getRequestDispatcher(urlRegister).forward(req,resp);
			
			return;
			}
			
		
		
			LocalDate today = LocalDate.now();
			
			boolean isSuccess = false;
			
			isSuccess = service.register(email,username,fullname,password,avatar,roleid,phone);
			
			
			
			System.out.println("check querry is sucess: " + isSuccess);
			if (isSuccess) {
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
			} else {
				
			alertMsg = "System error!";
				req.setAttribute("alert", alertMsg);
				
				resp.sendRedirect(req.getContextPath() + "/register");
				
			return;	
			}
			
			
			if (service.checkExistEmail(email)) {
				alertMsg = "Email đã tồn tại!";
				req.setAttribute("alert", alertMsg);
				String urlRegister = "/register";
				req.getRequestDispatcher(urlRegister).forward(req,
				resp);
				return;
				}
			
		 } catch (Exception e) {
	         e.printStackTrace();
	         // Lỗi kỹ thuật, ví dụ: lỗi kết nối database
	         req.setAttribute("errorMessage", "Đã xảy ra lỗi hệ thống. Vui lòng thử lại sau.");
	         req.getRequestDispatcher("/register").forward(req, resp);
	     }
	}
	

}
