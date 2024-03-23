package com.kampus.kbazaar.cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @Column(name = "shopper_id")
    private Long shopperId;

    @Column(name = "products", nullable = true)
    private String products;

    @Column(name = "promotions", nullable = true)
    private String promotions;
}
