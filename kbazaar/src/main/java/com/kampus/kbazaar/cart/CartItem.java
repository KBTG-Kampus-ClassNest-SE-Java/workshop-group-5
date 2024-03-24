package com.kampus.kbazaar.cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cart_id", nullable = false)
    private int cart_id;

    @Column(name = "product_id", nullable = false)
    private int product_id;

    @Column(name = "quantity", nullable = true)
    private int quantity;
}
