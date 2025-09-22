package ltweb.daos;

import java.util.List;
import ltweb.models.Category;

public interface CategoryDAO {
    void insert(Category category);
    void edit(Category category);
    void delete(int id);
    Category get(int id);
    Category get(String name); 
    List<Category> search(String keyword);
    List<Category> getAll();
}

