//package uth.edu.backend.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Column;
//
//@Entity
//public class Guest {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String address;
//
//    // Constructors
//    public Guest() {}
//
//    public Guest(String name, String email, String address) {
//        this.name = name;
//        this.email = email;
//        this.address = address;
//    }
//
//    // Getters and Setters
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    @Override
//    public String toString() {
//        return "Guest{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }
//}
