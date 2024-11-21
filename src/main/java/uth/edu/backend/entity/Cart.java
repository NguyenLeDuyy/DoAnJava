package uth.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
        import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Cart")
@EqualsAndHashCode(exclude = {"user", "cartDetails", "orders"})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartId", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "UserId", nullable = false)
    @JsonBackReference
    private User user;

    @ColumnDefault("'Chua thanh toan'")
    @Column(name = "Status", length = 50)
    private String status = "Chua thanh toan";

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private Set<Order> orders = new LinkedHashSet<>();
}