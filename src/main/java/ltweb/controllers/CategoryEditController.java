package ltweb.controllers;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import ltweb.models.Category;
import ltweb.services.CategoryService;
import ltweb.services.Impl.CategoryServiceImpl;

@WebServlet("/admin/category/edit")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  // 1MB
    maxFileSize = 1024 * 1024 * 5,    // 5MB
    maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class CategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Category category = cateService.get(id);

            if (category == null) {
                resp.sendRedirect(req.getContextPath() + "/admin/category/list");
                return;
            }

            req.setAttribute("category", category);
            req.getRequestDispatcher("/views/admin/category/edit-category.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            String name = req.getParameter("name");

            // Lấy category hiện tại để giữ lại icon nếu không đổi
            Category existingCategory = cateService.get(id);
            if (existingCategory == null) {
                resp.sendRedirect(req.getContextPath() + "/admin/category/list");
                return;
            }

            Part filePart = req.getPart("icon");
            String fileName = filePart.getSubmittedFileName();

            String iconPath = existingCategory.getIcon(); // giữ icon cũ
            if (fileName != null && !fileName.isEmpty()) {
                // Lưu file mới
                String uploadPath = "C:\\DTTX SPKT\\LAPTRINHWEB - T2\\upload";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdir();

                String filePath = uploadPath + File.separator + fileName;
                filePart.write(filePath);

                iconPath = "uploads/" + fileName;
            }

            // Cập nhật category
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            category.setIcon(iconPath);

            cateService.edit(category);

            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        }
    }
}
