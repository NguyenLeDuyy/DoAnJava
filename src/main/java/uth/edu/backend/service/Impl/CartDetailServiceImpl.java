package uth.edu.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.repository.CartDetailRepository;
import uth.edu.backend.service.CartDetailService;

@Service
public class CartDetailServiceImpl implements CartDetailService {

//    @Autowired
//    private CartDetailRepository cartDetailRepository;

    @Override
    public void addProductToCart(Cart cart, Long productId, int quantity) {


    }
}
