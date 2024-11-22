package uth.edu.backend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.backend.entity.Category;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.Role;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class FlowerAdminController {
    @Autowired
    private CategoryService categoryService;


    @Autowired
    private FlowerService flowerService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/flower")
    public String index(Model model) {
        List<Flower> list = flowerService.getAllFlowers();
        model.addAttribute("listFlowers", list);
        return "admin/flower/index";
    }

    @GetMapping("/flower-add")
    public String add(Model model) {
        Flower flower = new Flower();
        List<Category> list = categoryService.getAllCategories();
        Role role = roleRepository.getById(3L);
        List<User> suppliers = userService.findByRole(role);

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

    @GetMapping("/edit-flower/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Flower flower = flowerService.findById(id);

        model.addAttribute("flower", flower);
        List<Category> list = categoryService.getAllCategories();
        Role role = roleRepository.getById(3L);
        List<User> suppliers = userService.findByRole(role);

        model.addAttribute("listCategories", list);
        model.addAttribute("listSuppliers", suppliers);
        return "admin/flower/edit";
    }

    @PostMapping("/edit-flower")
    public String update(@ModelAttribute("flower") Flower flower, @RequestParam("file") MultipartFile file) {

        String fileName = file.getOriginalFilename();
        boolean isEmty = fileName == null || fileName.trim().length() == 0;
        if(!isEmty){
            // upload file
            this.storageService.store(file);
            flower.setImageUrl(fileName);
        }
        if(this.flowerService.update(flower)) {
            return "redirect:/admin/flower";
        }
        else {
            return "admin/flower/edit";
        }
    }

    @GetMapping("/delete-flower/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if(this.flowerService.deleteFlower(id)) {
            return "redirect:/admin/flower";
        }
        else {
            return "admin/flower/index";
        }
    }

//    @DeleteMapping("/{id}")
//    public boolean deleteFlower(@PathVariable("id") Integer id) {
//        return flowerService.deleteFlower(id);
//    }

    @DeleteMapping("/delete-flower/{id}")
    public boolean deleteFlower(@PathVariable("id") Integer id) {
        return flowerService.deleteFlower(id);
    }



//    public String update(@ModelAttribute("flower") Flower flower) {
//        if (flowerService.update(flower)) {
//            return "redirect:/admin/flower";
//        } else {
//            return "admin/flower/edit";
//        }
//    }

}
