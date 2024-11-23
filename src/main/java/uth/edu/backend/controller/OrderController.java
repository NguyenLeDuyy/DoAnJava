package uth.edu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.entity.Order;
import uth.edu.backend.service.Impl.OrderServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    // api create order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // api cập nhật order
    @PutMapping
    public Order updateOrder(@RequestParam("id") Integer id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    // api xóa order
    @DeleteMapping("/{id}")
    public boolean deleteOrder(@PathVariable("id") Integer id) {
        return orderService.deleteOrder(id);
    }

    // api lấy danh sách order
    @GetMapping("/list")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // api lấy 1 order
    @GetMapping("/{id}")
    public Order getOneOrder(@PathVariable("id") Integer id) {
        return orderService.getOneOrder(id);
    }
}
