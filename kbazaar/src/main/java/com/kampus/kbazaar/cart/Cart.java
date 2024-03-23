package com.kampus.kbazaar.cart;

import com.kampus.kbazaar.product.Product;
import jakarta.persistence.Entity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cart")
@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private Long shopper_id;
    private List<Product> products;
}
