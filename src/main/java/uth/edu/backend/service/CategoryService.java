package uth.edu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.repository.CategoryRepository;
import uth.edu.backend.model.Category;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // tạo category
    public Category createCategory(Category category) {
        if (category != null) {
            return categoryRepository.save(category);
        }
        return null;
    }

    // cập nhật thông tin category
    public Category updateCategory(Integer id, Category category) {
        if (category != null) {
            Category category1 = categoryRepository.getById(id);
            if (category1 != null) {
                category1.setCategoryName(category.getCategoryName());

                return categoryRepository.save(category1);
            }
        }
        return null;
    }

    // xóa category
    public boolean deleteCategory(Integer id) {
        if (id >= 1) {
            Category category = categoryRepository.getById(id);
            if (category != null) {
                categoryRepository.delete(category);
                return true;
            }
        }
        return false;
    }

    // lấy danh sách các category
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // lấy một category
    public Category getOneCategory(Integer id) {
        return categoryRepository.getById(id);
    }
}
