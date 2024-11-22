//package uth.edu.backend.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class OrderGuest {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne
//    private Cart cart;
//
//    // Các thông tin về khách vãng lai
//    private String guestName;
//    private String guestEmail;
//    private String guestAddress;
//
//    // Constructors, Getters and Setters
//    public OrderGuest() {}
//
//    public OrderGuest(Cart cart, String guestName, String guestEmail, String guestAddress) {
//        this.cart = cart;
//        this.guestName = guestName;
//        this.guestEmail = guestEmail;
//        this.guestAddress = guestAddress;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }
//
//    public String getGuestName() {
//        return guestName;
//    }
//
//    public void setGuestName(String guestName) {
//        this.guestName = guestName;
//    }
//
//    public String getGuestEmail() {
//        return guestEmail;
//    }
//
//    public void setGuestEmail(String guestEmail) {
//        this.guestEmail = guestEmail;
//    }
//
//    public String getGuestAddress() {
//        return guestAddress;
//    }
//
//    public void setGuestAddress(String guestAddress) {
//        this.guestAddress = guestAddress;
//    }
//}
