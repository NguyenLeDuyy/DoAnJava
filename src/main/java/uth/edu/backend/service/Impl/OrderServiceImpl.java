package uth.edu.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.CartDetail;
import uth.edu.backend.entity.OrderDetail;
import uth.edu.backend.repository.CartDetailRepository;
import uth.edu.backend.repository.CartRepository;
import uth.edu.backend.repository.OrderDetailRepository;
import uth.edu.backend.repository.OrderRepository;
import uth.edu.backend.entity.Order;
import uth.edu.backend.service.OrderService;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

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

    @Override
    public void saveOrder(Cart cart) {
        Order order = new Order();
        order.setOrderStatus("PENDING");
        Instant lt = Instant.now();
        order.setOrderDate(lt);
        order.setTotalPrice(BigDecimal.valueOf(cart.getTotalPrice()));

        List<OrderDetail> orderDetailList = new ArrayList<>();

        for(CartDetail item : cart.getCartDetails()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setFlower(item.getFlower());
//            orderDetail.setUnitPrice(orderDetail.getCostPrice());
            orderDetailRepository.save(orderDetail);
            orderDetailList.add(orderDetail);
            cartDetailRepository.delete(item);
        }

        order.setOrderDetails(orderDetailList);
        cart.setTotalItems(0);
        cart.setTotalPrice((double) 0);
        orderRepository.save(order);
        cartRepository.save(cart);
    }
}
