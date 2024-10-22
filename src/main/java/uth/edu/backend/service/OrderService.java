package uth.edu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.repository.OrderRepository;
import uth.edu.backend.model.Order;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // tạo order
    public Order createOrder(Order order) {
        if (order != null) {
            return orderRepository.save(order);
        }
        return null;
    }

    // update thông tin order
    public Order updateOrder(Integer id, Order order) {
        if (order != null) {
            Order order1 = orderRepository.getById(id);
            if (order1 != null) {
                order1.setPaymentMethod(order.getPaymentMethod());
                order1.setOrderStatus(order.getOrderStatus());
                order1.setShippingAddress(order.getShippingAddress());

                return orderRepository.save(order1);
            }
        }
        return null;
    }

    // Xóa order
    public boolean deleteOrder(Integer id) {
        if (id >= 1) {
            Order order = orderRepository.getById(id);
            if (order != null) {
                orderRepository.delete(order);
                return true;
            }
        }
        return false;
    }

    // Lấy danh sách tất cả các order
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Lấy thông tin của một order
    public Order getOneOrder(Integer id) {
        return orderRepository.getById(id);
    }
}

