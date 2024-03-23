package com.kampus.kbazaar.cart;

import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public String deleteCartItem(String username, String product_sku) {
        return "deleteL: " + username + product_sku;
    }
}
