package uth.edu.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
@EqualsAndHashCode(exclude = {"cart", "orders", "userDetails", "userRoles"})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private Long id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Password", nullable = false, length = 1000)
    private String password;

    @Column(name = "ConfirmPassword", nullable = false, length = 1000, columnDefinition = "varchar(1000) default '123456'")
    private String confirmPassword = "123456";

    @Column(name = "Email", length = 320)
    private String email;

    @Column(name = "PhoneNumber", length = 15)
    private String phoneNumber;

    @Column(name = "enabled")
    boolean enabled = true;

    @ColumnDefault("2")
    @Column(name = "Role")
    private Integer role = 2; // Set default value to 0

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Cart cart;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    Set<UserDetail> userDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    Set<UserRole> userRoles = new LinkedHashSet<>();
}