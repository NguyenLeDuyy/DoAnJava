package uth.edu.backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
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
    Instant createdDate;

    @ColumnDefault("getdate()")
    @Column(name = "LastModifiedDate")
    Instant lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "CategoryId", nullable = false)
    @JsonManagedReference
    Category category;

    @OneToMany(mappedBy = "flower")
    Set<CartDetail> cartDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "flower")
    Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "flower")
    Set<UserDetail> userDetails = new LinkedHashSet<>();
}