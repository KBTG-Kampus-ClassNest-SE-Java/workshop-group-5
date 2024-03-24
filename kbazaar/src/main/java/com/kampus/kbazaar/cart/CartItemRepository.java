package com.kampus.kbazaar.cart;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query(
            value =
                    "select ct.id, ct.cart_id, ct.product_id, ct.quantity from cart_item ct where ct.cart_id = :cartId",
            nativeQuery = true)
    List<CartItem> findByCartId(Long cartId);
}
