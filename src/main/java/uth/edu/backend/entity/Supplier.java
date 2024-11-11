package uth.edu.backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "SupplierName")
    String name;

    @Column(name = "Address")
    String address;

    @Column(name = "Phone")
    String phone;

    @Column(name = "Email")
    String email;

    @Column(name = "Status")
    String status;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    Set<Flower> flowers = new LinkedHashSet<>();

}
