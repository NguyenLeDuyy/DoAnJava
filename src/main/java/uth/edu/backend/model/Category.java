package uth.edu.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "CategoryName", nullable = false, length = 50)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Flower> flowers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(Set<Flower> flowers) {
        this.flowers = flowers;
    }

}