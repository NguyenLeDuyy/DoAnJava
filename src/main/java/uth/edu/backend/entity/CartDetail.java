package uth.edu.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "CartDetail", indexes = {
        @Index(name = "IX_CartDetail_CartId", columnList = "CartId"),
        @Index(name = "IX_CartDetail_FlowerId", columnList = "FlowerId")
})
@Data
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartDetailId", nullable = false)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CartId", nullable = false)
    private Cart cart;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FlowerId", nullable = false)
    private Flower flower;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Price", nullable = false, precision = 18, scale = 2)
    private BigDecimal totalPrice;

//    @Column(name = "UnitPrice", nullable = false)
//    private Short unitPrice;
}