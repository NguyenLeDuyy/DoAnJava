package uth.edu.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "CartDetail")
@EqualsAndHashCode(exclude = { "cart", "flower" })
public class CartDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartDetailId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CartId", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FlowerId", nullable = false)
    private Flower flower;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Price", nullable = false, precision = 18, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "CostPrice", nullable = true, precision = 18, scale = 2)
    private BigDecimal costPrice;
}