package uth.edu.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.repository.CategoryRepository;
import uth.edu.backend.entity.Category;
import uth.edu.backend.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
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
    @Override
    public Boolean deleteCategory(Integer id) {
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
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // lấy một category
    public Category getOneCategory(Integer id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Boolean create(Category category) {
        try {
            this.categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

   @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Boolean update(Category category) {
        try {
            this.categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
