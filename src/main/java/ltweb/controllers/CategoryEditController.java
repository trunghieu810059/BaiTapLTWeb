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
@MultipartConfig
public class CategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = cateService.get(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/views/admin/edit-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        Part filePart = req.getPart("icon");
        String fileName = filePart.getSubmittedFileName();

        Category category = cateService.get(id);
        category.setName(name);

        if (fileName != null && !fileName.isEmpty()) {
            String uploadPath = getServletContext().getRealPath("C:\\DTTX SPKT\\LAPTRINHWEB - T2\\upload");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);

            category.setIcon("C:\\DTTX SPKT\\LAPTRINHWEB - T2\\upload" + fileName);
        }

        cateService.edit(category);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}

