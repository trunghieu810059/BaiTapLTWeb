package ltweb.controllers;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltweb.models.Category;
import ltweb.services.CategoryService;
import ltweb.services.Impl.CategoryServiceImpl;

@WebServlet("/admin/category/list")
public class CategoryController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse
	resp) throws ServletException, IOException {
	List<Category> cateList = cateService.getAll();
	req.setAttribute("cateList", cateList);
	req.getRequestDispatcher("/views/admin/category/list-category.jsp").forward(req, resp);
	}
	
}
	


