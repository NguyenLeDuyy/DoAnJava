package uth.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FlowerId", nullable = false)
    Integer id;

    @Nationalized
    @Column(name = "FlowerName", nullable = false)
    String flowerName;

    @Nationalized
    @Lob
    @Column(name = "Description")
    String description;

    @Column(name = "Price", nullable = false, precision = 18, scale = 2)
    BigDecimal price;

    @Nationalized
    @Lob
    @Column(name = "ImageUrl")
    String imageUrl;

    @Nationalized
    @Column(name = "Season", length = 50)
    String season;

    @ColumnDefault("getdate()")
    @Column(name = "CreatedDate")
    LocalDate createdDate;

    @ColumnDefault("getdate()")
    @Column(name = "LastModifiedDate")
    LocalDate lastModifiedDate;

    @Column(name = "quantity", nullable = false)
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "CategoryId", nullable = false)
    @JsonManagedReference
    Category category;

    @OneToMany(mappedBy = "flower", fetch = FetchType.LAZY)
    Set<CartDetail> cartDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "flower", fetch = FetchType.LAZY)
    Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "flower", fetch = FetchType.LAZY)
    Set<UserDetail> userDetails = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "SupplierId")
    Supplier supplier;

}