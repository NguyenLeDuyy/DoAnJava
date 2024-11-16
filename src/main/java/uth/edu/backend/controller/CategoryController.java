package uth.edu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.entity.Category;
import uth.edu.backend.service.Impl.CategoryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    // api create category
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryServiceImpl.createCategory(category);
    }

    // api cập nhật category
    @PutMapping
    public Category updateCategory(@RequestParam("id") Integer id, @RequestBody Category category) {
        return categoryServiceImpl.updateCategory(id, category);
    }

    // api xóa category
    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable("id") Integer id) {
        return categoryServiceImpl.deleteCategory(id);
    }

    // api lấy danh sách category
    @GetMapping("/list")
    public List<Category> getAllCategories() {
        return categoryServiceImpl.getAllCategories();
    }

    // api lấy 1 category
    @GetMapping("/{id}")
    public Category getOneCategory(@PathVariable("id") Integer id) {
        return categoryServiceImpl.getOneCategory(id);
    }
}
