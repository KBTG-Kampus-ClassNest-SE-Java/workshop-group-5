package com.kampus.kbazaar.cart;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(
            value =
                    "select ct.cart_id, ct.shopper_id, ct.promotions from cart ct where ct.shopper_id = :shopperId",
            nativeQuery = true)
    Optional<Cart> findByShopperId(int shopperId);
}
