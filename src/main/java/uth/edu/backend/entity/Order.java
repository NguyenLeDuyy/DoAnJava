package uth.edu.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"Order\"")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CartId", nullable = false)
    private Cart cart;

    @ColumnDefault("getdate()")
    @Column(name = "OrderDate", nullable = false)
    private Instant orderDate;

    @Column(name = "TotalPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal totalPrice;

    @Nationalized
    @Lob
    @Column(name = "ShippingAddress", nullable = false)
    private String shippingAddress;

    @Column(name = "OrderStatus", nullable = false)
    private String orderStatus;

    @Nationalized
    @Column(name = "PaymentMethod", nullable = false, length = 50)
    private String paymentMethod;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails = new ArrayList<>();

}