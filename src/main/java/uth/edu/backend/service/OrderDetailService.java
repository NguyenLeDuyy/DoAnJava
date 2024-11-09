package uth.edu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.repository.OrderDetailRepository;
import uth.edu.backend.entity.OrderDetail;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    // Tạo order detail
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        if (orderDetail != null) {
            return orderDetailRepository.save(orderDetail);
        }
        return null;
    }

    // Update thông tin order detail
    public OrderDetail updateOrderDetail(Integer id, OrderDetail orderDetail) {
        if (orderDetail != null) {
            OrderDetail orderDetail1 = orderDetailRepository.getById(id);
            if (orderDetail1 != null) {
                orderDetail1.setFlower(orderDetail.getFlower());
                orderDetail1.setQuantity(orderDetail.getQuantity());
                orderDetail1.setUnitPrice(orderDetail.getUnitPrice());

                return orderDetailRepository.save(orderDetail1);
            }
        }
        return null;
    }

    // Lấy danh sách tất cả các order detail
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    // Lấy thông tin của một order detail
    public OrderDetail getOneOrderDetail(Integer id) {
        return orderDetailRepository.getById(id);
    }
}
