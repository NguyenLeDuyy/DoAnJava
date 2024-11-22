//package uth.edu.backend.controller.mvc;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import uth.edu.backend.entity.Guest;
//import uth.edu.backend.entity.Cart;
//import uth.edu.backend.entity.Order;
//import uth.edu.backend.entity.OrderGuest;
//import uth.edu.backend.service.CartService;
//import uth.edu.backend.service.OrderService;
//import uth.edu.backend.service.OrderGuestService;
//
//import java.security.Principal;
//
//@Controller
//public class OrderGuestMvcController {
//
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private OrderGuestService guestService;
//    @Autowired
//    private OrderGuestService orderGuestService;
//
//    @PostMapping("/place-order")
//    public String placeOrder(@RequestParam(value = "guestName", required = false) String guestName,
//                             @RequestParam(value = "guestEmail", required = false) String guestEmail,
//                             @RequestParam(value = "guestAddress", required = false) String guestAddress,
//                             HttpSession session, Principal principal, Model model) {
//
//        Cart cart;
//        Guest guest = null;
//
//        if (principal != null) {
//            // Đơn hàng của người dùng đã đăng ký
//            Integer userId = (Integer) session.getAttribute("userId");
//            cart = cartService.findByUserId(Long.valueOf(userId));
//
//            if (cart == null || cart.getId() == null) {
//                model.addAttribute("error", "No active cart found for the user.");
//                return "redirect:/cart";
//            }
//
//            System.out.println("User Order: " + userId);
//            // Xử lý đơn hàng của người dùng đã đăng ký
//        } else {
//            // Đơn hàng của khách vãng lai
//            if (guestName == null || guestEmail == null || guestAddress == null) {
//                model.addAttribute("error", "Guest information is incomplete.");
//                return "redirect:/cart"; // Hoặc trang lỗi nếu thông tin không đủ
//            }
//
//            // Tạo đối tượng OrderGuest thay vì Guest
//            OrderGuest orderGuest = new OrderGuest();
//            orderGuest.setGuestName(guestName);
//            orderGuest.setGuestEmail(guestEmail);
//            orderGuest.setGuestAddress(guestAddress);
//
//            // Gọi phương thức tạo OrderGuest
//            guestService.createOrderGuest(orderGuest);
//
//            cart = (Cart) session.getAttribute("guestCart");
//            if (cart == null) {
//                cart = new Cart();
//                session.setAttribute("guestCart", cart);
//            }
//
//            System.out.println("Guest Order: " + orderGuest.getId() + " - " + orderGuest.getGuestName() + ", " + orderGuest.getGuestEmail() + ", " + orderGuest.getGuestAddress());
//            // Lưu đơn hàng của khách vãng lai vào cơ sở dữ liệu
//        }
//
//        // Tạo đơn hàng và gán thông tin khách nếu là khách vãng lai
//        if (cart != null) {
//            OrderGuest orderGuest = new OrderGuest(); // Tạo đối tượng Order từ OrderGuest
//            orderGuest.setCart(cart);
//
//            // Always set guest information for guest orders
//            if (guestName != null && guestEmail != null && guestAddress != null) {
//                orderGuest.setGuestName(guestName);
//                orderGuest.setGuestEmail(guestEmail);
//                orderGuest.setGuestAddress(guestAddress);
//            }
//
//            // Gọi phương thức createOrder với đối tượng Order
//            orderGuestService.createOrderGuest(orderGuest);
//
//            // Xóa giỏ hàng sau khi đặt hàng
//            if (principal != null) {
//                cartService.clearCart(cart); // Chuyển sang đối tượng Cart thay vì ID
//            } else {
//                session.removeAttribute("guestCart");
//            }
//        }
//
//        return "order-success"; // Trang thành công sau khi đặt hàng
//    }
//}
