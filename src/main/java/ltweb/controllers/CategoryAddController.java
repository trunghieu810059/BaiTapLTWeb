package ltweb.controllers;

import java.io.File;
import java.io.IOException;

import ltweb.models.Category;
import ltweb.services.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import ltweb.services.Impl.CategoryServiceImpl;

@WebServlet("/admin/category/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/admin/category/add-category.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		Part filePart = req.getPart("icon");
		String fileName = filePart.getSubmittedFileName();

		// Lưu file vào thư mục webapp/uploads
		String uploadPath = getServletContext().getRealPath("/uploads");
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdirs();

		// Ghi file vào thư mục uploads
		filePart.write(uploadPath + File.separator + fileName);

		// Lưu vào DB (lưu đường dẫn tương đối để JSP có thể load)
		Category category = new Category();
		category.setName(name);
		category.setIcon("uploads/" + fileName);

		cateService.insert(category);

		// Redirect để tránh form submit lại khi refresh
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
