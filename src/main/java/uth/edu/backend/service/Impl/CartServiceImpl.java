package uth.edu.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.dto.request.*;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.CartDetail;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.entity.User;
import uth.edu.backend.repository.CartDetailRepository;
import uth.edu.backend.repository.CartRepository;
import uth.edu.backend.repository.UserRepository;
import uth.edu.backend.service.CartService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart createCart(CartCreationRequest request) {
        Cart cart = new Cart();

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not exists"));
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    /*public ApiResponse<User> createUser(UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists");
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(savedUser);
        cartRepository.save(cart);

        apiResponse.setResult(savedUser);
        return apiResponse;
    }*/

    public List<Cart> getCarts(){
        return cartRepository.findAll();
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Cart updateCart(Long cartID, CartUpdateRequest request) {
        Cart cart = getCart(cartID);
        cart.setStatus(request.getStatus());

        return cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public Cart addProductToCart(Flower flower, int quantity, User user) {
        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }

        Set<CartDetail> cartDetails = cart.getCartDetails();
        CartDetail cartDetail = findCartDetail(cartDetails, flower.getId());
        if(cartDetails == null) {
            cartDetails = new HashSet<>();
            if (cartDetail == null){
                cartDetail = new CartDetail();
                cartDetail.setCart(cart);
                cartDetail.setFlower(flower);
                cartDetail.setQuantity(quantity);
                cartDetail.setTotalPrice(BigDecimal.valueOf(flower.getPrice() * quantity));
                cartDetails.add(cartDetail);
                cartDetailRepository.save(cartDetail);
            }
        }else {
            if (cartDetail == null){
                cartDetail = new CartDetail();
                cartDetail.setCart(cart);
                cartDetail.setFlower(flower);
                cartDetail.setQuantity(quantity);
                cartDetail.setTotalPrice(BigDecimal.valueOf(flower.getPrice() * quantity));
                cartDetails.add(cartDetail);
                cartDetailRepository.save(cartDetail);
            }else {
                cartDetail.setQuantity(cartDetail.getQuantity() + quantity);
                cartDetail.setTotalPrice(BigDecimal.valueOf(flower.getPrice() * cartDetail.getQuantity()));
                cartDetailRepository.save(cartDetail);
            }
        }
        cart.setCartDetails(cartDetails);
        int totalItems = totalItems(cart.getCartDetails());
        double totalPrice = totalPrice(cart.getCartDetails());

        cart.setTotalItems(totalItems);
        cart.setTotalPrice(totalPrice);
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    @Override
    public Cart updateProductInCart(Flower flower, int quantity, User user) {
        Cart cart = user.getCart();

        Set<CartDetail> cartDetails = cart.getCartDetails();

        CartDetail detail = findCartDetail(cartDetails, flower.getId());

        detail.setQuantity(quantity);
        detail.setTotalPrice(BigDecimal.valueOf(flower.getPrice() * quantity));
        cartDetailRepository.save(detail);

        int totalItems = totalItems(cart.getCartDetails());
        double totalPrice = totalPrice(cart.getCartDetails());

        cart.setTotalItems(totalItems);
        cart.setTotalPrice(totalPrice);

        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteProductFromCart(Flower flower, User user) {
        Cart cart = user.getCart();

        Set<CartDetail> cartDetails = cart.getCartDetails();

        CartDetail detail = findCartDetail(cartDetails, flower.getId());

        cartDetails.remove(detail);

        cartDetailRepository.delete(detail);


        int totalItems = totalItems(cart.getCartDetails());
        double totalPrice = totalPrice(cart.getCartDetails());

        cart.setCartDetails(cartDetails);
        cart.setTotalItems(totalItems);
        cart.setTotalPrice(totalPrice);

        return cartRepository.save(cart);
    }

    private CartDetail findCartDetail(Set<CartDetail> cartDetails, Integer productId) {
        if(cartDetails == null) {
            return null;
        }
        CartDetail cartDetail = null;

        for (CartDetail detail : cartDetails) {
            if(detail.getFlower().getId().equals(productId)) {
                cartDetail = detail;
                break;
            }
        }
        return cartDetail;
    }

    private int totalItems(Set<CartDetail> cartDetails) {
        int totalItems = 0;
        for (CartDetail detail : cartDetails) {
            totalItems += detail.getQuantity();
        }
        return totalItems;
    }

    private double totalPrice(Set<CartDetail> cartDetails) {
        double totalPrice = 0;
        for (CartDetail detail : cartDetails) {
            totalPrice += detail.getTotalPrice().doubleValue();
        }
        return totalPrice;
    }

    @Override
    public Cart findByUserId(Long userId) {
        return cartRepository.findByUserId(userId);

    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Cart cart, Long productId) {

    }

    @Override
    public void updateQuantity(Cart cart, Long productId, int quantity) {

    }

    @Override
    public void clearCart(Cart cart) {

    }

    @Override
    public void checkout(Cart cart) {

    }
}