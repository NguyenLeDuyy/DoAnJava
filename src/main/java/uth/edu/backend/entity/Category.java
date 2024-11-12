package uth.edu.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Nationalized;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "CategoryName", nullable = false, length = 50)
    private String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Flower> flowers = new LinkedHashSet<>();
}