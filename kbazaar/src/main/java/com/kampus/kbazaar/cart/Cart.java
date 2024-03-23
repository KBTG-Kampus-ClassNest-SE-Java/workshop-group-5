package com.kampus.kbazaar.cart;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cart")
@Getter
@Setter
public class Cart {
    @EmbeddedId private CartId cartId;
    private Integer quantity;

    public Cart(CartId cartId, Integer quantity) {
        this.cartId = cartId;
        this.quantity = quantity;
    }
}
