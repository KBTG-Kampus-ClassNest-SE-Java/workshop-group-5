package com.kampus.kbazaar.cart;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Getter;

@Getter
@Embeddable
public class CartId implements Serializable {
    private Long shopper_id;
    private Long product_id;

    public CartId(Long shopper_id, Long product_id) {
        this.shopper_id = shopper_id;
        this.product_id = product_id;
    }
}
