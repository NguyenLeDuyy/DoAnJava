//package uth.edu.backend.controller.mvc;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import uth.edu.backend.entity.Flower;
//import uth.edu.backend.entity.User;
//import uth.edu.backend.service.FlowerService;
//import uth.edu.backend.service.UserService;
//
//import java.security.Principal;
//import java.util.List;
//
//@Controller
//@SessionAttributes({ "userId", "username" })
//public class HomeController {
//
//    @Autowired
//    private FlowerService flowerService;
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/") // Add this
//    public String home(Model model, HttpSession session, Principal principal) { // Add Principal
//        if (principal != null) {
//            // Get authenticated user details
//            String username = principal.getName();
//            User user = userService.findByUsername(username);
//            // Store in session
//            session.setAttribute("userId", user.getId());
//            session.setAttribute("username", user.getUsername());
//            model.addAttribute("userId", user.getId());
//            model.addAttribute("username", user.getUsername());
//        }
//
//        List<Flower> topFlowers = flowerService.findTop5Flowers();
//        List<Flower> lastFlowers = flowerService.findLast6Flowers();
//
//        model.addAttribute("topFlowers", topFlowers);
//        model.addAttribute("lastFlowers", lastFlowers);
//
//        return "index";
//    }
//
//    @RequestMapping("/product")
//    public String product(Model model) {
//        List<Flower> list = flowerService.getAllFlowers();
//        model.addAttribute("listFlowers", list);
//        return "product";
//    }
//
//
//    @RequestMapping("/product-detail")
//    public String productDetail(@RequestParam("id") Integer id, Model model) {
//        Flower flower = flowerService.getOneFlower(id);
//        model.addAttribute("flower", flower);
//        List<Flower> listFlowers = flowerService.getAllFlowers();
//        model.addAttribute("listFlowers", listFlowers);
//
//        return "product-detail";
//    }
//
//
//
//    @RequestMapping("/user")
//    public String user(Model model, HttpSession session, Principal principal) {
//        if (principal != null) {
//            // Get authenticated user details
//            String username = principal.getName();
//            User user = userService.findByUsername(username);
//            // Store in session
////             session.setAttribute("userId", user.getId());
////             session.setAttribute("username", user.getUsername());
//            model.addAttribute("userId", user.getId());
//            model.addAttribute("username", user.getUsername());
//        } else {
//            // Clear session if no authenticated user
//            session.removeAttribute("userId");
//        }
//        return "user";
//    }
//
//    // Example of working with Principal (logged in user)
//    @RequestMapping("/profile")
//    public String profile(Model model, Principal principal) {
//        if (principal != null) {
//            model.addAttribute("username", principal.getName());
//        }
//        return "profile";
//    }
//}

package uth.edu.backend.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.FlowerService;
import uth.edu.backend.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes({ "userId", "username", "guestId" }) // Thêm "guestId"
public class HomeController {

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(Model model, HttpSession session, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            model.addAttribute("userId", user.getId());
            model.addAttribute("username", user.getUsername());
        } else if (session.getAttribute("guestId") == null) {
            String guestId = "GUEST_" + System.currentTimeMillis();
            session.setAttribute("guestId", guestId);
            model.addAttribute("guestId", guestId);
        } else {
            model.addAttribute("guestId", session.getAttribute("guestId"));
        }

        List<Flower> topFlowers = flowerService.findTop5Flowers();
        List<Flower> lastFlowers = flowerService.findLast6Flowers();
        model.addAttribute("topFlowers", topFlowers);
        model.addAttribute("lastFlowers", lastFlowers);

        return "index";
    }

    @RequestMapping("/product")
    public String product(Model model) {
        List<Flower> list = flowerService.getAllFlowers();
        model.addAttribute("listFlowers", list);
        return "product";
    }

    @RequestMapping("/product-detail")
    public String productDetail(@RequestParam("id") Integer id, Model model) {
        Flower flower = flowerService.getOneFlower(id);
        model.addAttribute("flower", flower);
        List<Flower> listFlowers = flowerService.getAllFlowers();
        model.addAttribute("listFlowers", listFlowers);
        return "product-detail";
    }

    @RequestMapping("/checkout")
    public String checkout(Model model, HttpSession session, Principal principal) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
            model.addAttribute("isGuest", false);
        } else {
            model.addAttribute("guestId", session.getAttribute("guestId"));
            model.addAttribute("isGuest", true);
        }
        return "checkout";
    }

    @RequestMapping("/place-order")
    public String placeOrder(@RequestParam(value = "guestName", required = false) String guestName,
                             @RequestParam(value = "guestEmail", required = false) String guestEmail,
                             @RequestParam(value = "guestAddress", required = false) String guestAddress,
                             HttpSession session, Principal principal) {
        if (principal != null) {
            Integer userId = (Integer) session.getAttribute("userId");
            System.out.println("User Order: " + userId);
        } else {
            String guestId = (String) session.getAttribute("guestId");
            System.out.println("Guest Order: " + guestId + " - " + guestName + ", " + guestEmail + ", " + guestAddress);
        }
        return "order-success";
    }
}

