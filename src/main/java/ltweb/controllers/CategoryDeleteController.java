package ltweb.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltweb.services.CategoryService;
import ltweb.services.Impl.CategoryServiceImpl;

@WebServlet("/admin/category/delete")
public class CategoryDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String idStr = req.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                cateService.delete(id); // gọi service xóa
            }
            // quay lại danh sách
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/admin/category/list?error=1");
        }
    }
}

