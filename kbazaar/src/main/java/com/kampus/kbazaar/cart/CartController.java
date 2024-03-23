package com.kampus.kbazaar.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public ResponseEntity getCart() { // NOSONAR
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/carts/{username}/items/{product_sku}")
    public String deleteCartItem(@PathVariable String username, @PathVariable String product_sku) {
        return cartService.deleteCartItem(username, product_sku);
    }
}
