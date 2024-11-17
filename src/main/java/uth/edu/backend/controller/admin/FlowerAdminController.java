package uth.edu.backend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.backend.entity.Category;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.Supplier;
import uth.edu.backend.service.CategoryService;
import uth.edu.backend.service.FlowerService;
import uth.edu.backend.service.StorageService;
import uth.edu.backend.service.SupplierService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class FlowerAdminController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private StorageService storageService;

    @RequestMapping("/flower")
    public String index(Model model) {

        List<Flower> list = flowerService.getAll();
        model.addAttribute("listFlowers", list);
        return "admin/flower/index";
    }

    @RequestMapping("/flower-add")
    public String add(Model model) {
        Flower flower = new Flower();
        List<Category> list = categoryService.getAllCategories();
        List<Supplier> suppliers = supplierService.getAllSuppliers();

        model.addAttribute("flower", flower);
        model.addAttribute("listCategories", list);
        model.addAttribute("listSuppliers", suppliers);
        return "admin/flower/add";
    }

    @PostMapping("/product-add")
    public String save(@ModelAttribute("flower") Flower flower, @RequestParam("file") MultipartFile file) {
        // upload file
        this.storageService.store(file);

        String fileName = file.getOriginalFilename();
        flower.setImageUrl(fileName);

        if(this.flowerService.create(flower)) {
            return "redirect:/admin/flower";
        }
        else {
            return "admin/flower/add";
        }
    }
}
