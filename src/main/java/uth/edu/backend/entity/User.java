package uth.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name = "UQ__Users__536C85E438E35360", columnNames = {"Username"})
})
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private Long id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Password", nullable = false, length = 1000)
    private String password;

    @Column(name = "Email", length = 320)
    private String email;

    @Column(name = "PhoneNumber", length = 15)
    private String phoneNumber;

    @ColumnDefault("0")
    @Column(name = "Role")
    private Integer role = 0; // Set default value to 0

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference
    private Cart cart;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserDetail> userDetails = new LinkedHashSet<>();


}