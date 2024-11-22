package uth.edu.backend.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/seller")
public class FlowerSellerController {
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
//        List<Flower> list = flowerService.findBySupplier();
        model.addAttribute("listFlowers", list);
        return "seller/flower/index";
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
        return "seller/flower/add";
    }

    @PostMapping("/product-add")
    public String save(@ModelAttribute("flower") Flower flower, @RequestParam("file") MultipartFile file) {
        // upload file
        this.storageService.store(file);

        String fileName = file.getOriginalFilename();
        flower.setImageUrl(fileName);

        flower.setSupplier(userService.findById(flower.getSupplier().getId()));

        if(this.flowerService.create(flower)) {
            return "redirect:/seller/flower";
        }
        else {
            return "seller/flower/add";
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
        return "seller/flower/edit";
    }

    @PostMapping("/edit-flower")
    public String update(@ModelAttribute("flower") Flower flower, @RequestParam("file") MultipartFile file) {

        String fileName = file.getOriginalFilename();
        boolean isEmty = fileName == null || fileName.trim().length() == 0;
        if(!isEmty){
            // upload file
            this.storageService.store(file);
            flower.setImageUrl(fileName);
            flower.setSupplier(userService.findById(flower.getSupplier().getId()));
        }
        if(this.flowerService.update(flower)) {
            return "redirect:/seller/flower";
        }
        else {
            return "seller/flower/edit";
        }
    }

    @GetMapping("/delete-flower/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if(this.flowerService.deleteFlower(id)) {
            return "redirect:/seller/flower";
        }
        else {
            return "seller/flower/index";
        }
    }


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