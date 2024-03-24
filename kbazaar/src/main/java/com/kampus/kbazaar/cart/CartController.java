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

    @PostMapping("/carts/{username}/items")
    public CartResponseDto addCartItem(
            @PathVariable String username, @RequestBody CartRequestDto cartRequestDto) {
        System.out.println("username : " + username);
        System.out.println("getProductSku : " + cartRequestDto.getProductSku());
        System.out.println("getQuantity : " + cartRequestDto.getQuantity());

        return cartService.addCartItem(
                username, cartRequestDto.getProductSku(), cartRequestDto.getQuantity());
    }
}
