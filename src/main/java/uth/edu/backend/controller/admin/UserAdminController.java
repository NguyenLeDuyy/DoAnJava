package uth.edu.backend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserAdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String index(Model model) {
        List<User> list = userService.getUsers();
        model.addAttribute("listUsers", list);

        return "admin/user/index";
    }

    @GetMapping("/user-add")
    public String add(Model model) {
        User user = new User();
//        user.setStatus("active");
        model.addAttribute("user", user);
        return "admin/user/add";
    }

    @PostMapping("/add-new-user")
    public String save(@ModelAttribute("user") User user) {
        if(this.userService.create(user)) {
            return "redirect:/admin/user";
        }
        else {
            return "admin/user/add";
        }
    }
//
    @GetMapping("/edit-user/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin/user/edit";
    }

    @PostMapping("/edit-user")
    public String update(@ModelAttribute("user") User user) {
        User existingUser = userService.findById(user.getId());
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(existingUser.getPassword());
        }
        user.setId(existingUser.getId());
        System.out.println(user);
        if (this.userService.update(user)) {
            return "redirect:/admin/user";
        } else {
            return "admin/user/edit";
        }
    }
//
    @GetMapping("/delete-user/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if(this.userService.deleteUser(id)) {
            return "redirect:/admin/user";
        }
        else {
            return "admin/user/index";
        }
    }

}
