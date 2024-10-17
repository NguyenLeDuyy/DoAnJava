package uth.edu.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name = "UQ__Users__536C85E438E35360", columnNames = {"Username"})
})
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
    @Column(name = "Role", nullable = false)
    private Integer role;

    @OneToMany(mappedBy = "user")
    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserDetail> userDetails = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<UserDetail> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Set<UserDetail> userDetails) {
        this.userDetails = userDetails;
    }

}