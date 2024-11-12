package uth.edu.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailId", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "OrderId", nullable = false)
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FlowerId", nullable = false)
    private Flower flower;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "UnitPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal unitPrice;
}