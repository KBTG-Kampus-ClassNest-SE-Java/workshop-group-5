package com.kampus.kbazaar.cart;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
public class CartItemId implements Serializable {
    private Integer cart_Id;
    private Integer product_Id;
}
