package uth.edu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uth.edu.backend.model.OrderDetail;
import uth.edu.backend.service.OrderDetailService;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    //api tạo order detail
    @PostMapping
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.createOrderDetail(orderDetail);
    }

    //api cập nhật order detail
    @PutMapping
    public OrderDetail updateOrderDetail(@RequestParam("id") Integer id, @RequestBody OrderDetail orderDetail) {
        return orderDetailService.updateOrderDetail(id, orderDetail);
    }

    //api lấy list order detail
    @GetMapping("/list")
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    //api lấy một order detail
    @GetMapping("/{id}")
    public OrderDetail getOneOrderDetail(@PathVariable("id") Integer id) {
        return orderDetailService.getOneOrderDetail(id);
    }
}
