package uth.edu.backend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.entity.Category;
import uth.edu.backend.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryAdminController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String index(Model model) {
        List<Category> list = categoryService.getAllCategories();
        model.addAttribute("listCategories", list);
        return "admin/category/index";
    }

    @GetMapping("/add-category")
    public String add(Model model) {
        Category category = new Category();
        category.setCategoryStatus("active");
        model.addAttribute("category", category);
        return "admin/category/add";
    }

    @PostMapping("/add-category")
    public String save(@ModelAttribute("category") Category category) {
        if(this.categoryService.create(category)) {
            return "redirect:/admin/category";
        }
        else {
            return "admin/category/add";
        }
    }

    @GetMapping("/edit-category/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/edit";
    }

    @PostMapping("/edit-category")
    public String update(@ModelAttribute("category") Category category) {
        if(this.categoryService.update(category)) {
            return "redirect:/admin/category";
        }
        else {
            return "admin/category/edit";
        }
    }

    @GetMapping("/delete-category/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if(this.categoryService.deleteCategory(id)) {
            return "redirect:/admin/category";
        }
        else {
            return "admin/category/index";
        }
    }

    // api create category
//    @PostMapping
//    public Category createCategory(@RequestBody Category category) {
//        return categoryService.create(category);
//    }
//
//    // api cập nhật category
//    @PutMapping
//    public Category updateCategory(@RequestParam("id") Integer id, @RequestBody Category category) {
//        return categoryService.updateCategory(id, category);
//    }

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
//    @GetMapping("/{id}")
//    public Category getOneCategory(@PathVariable("id") Integer id) {
//        return categoryService.getOneCategory(id);
//    }
}
