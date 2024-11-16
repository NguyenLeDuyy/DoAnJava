package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Boolean create(Category category);
    Boolean update(Category category);
    Boolean deleteCategory(Integer id);
    Category findById(Integer id);

}
