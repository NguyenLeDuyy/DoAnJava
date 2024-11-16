package uth.edu.backend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.entity.Category;
import uth.edu.backend.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String index() {

        return "admin/category/index";
    }

    // api create category
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // api cập nhật category
    @PutMapping
    public Category updateCategory(@RequestParam("id") Integer id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    // api xóa category
    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable("id") Integer id) {
        return categoryService.deleteCategory(id);
    }

    // api lấy danh sách category
    @GetMapping("/list")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // api lấy 1 category
    @GetMapping("/{id}")
    public Category getOneCategory(@PathVariable("id") Integer id) {
        return categoryService.getOneCategory(id);
    }
}
