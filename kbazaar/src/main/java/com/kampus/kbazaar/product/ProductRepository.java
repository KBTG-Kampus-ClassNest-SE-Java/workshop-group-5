package com.kampus.kbazaar.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findBySku(String sku);

    @Query(
            value =
                    "SELECT id, name, price, quantity, sku FROM product p ORDER BY p.id offset ?1 limit ?2",
            nativeQuery = true)
    List<Product> findByPageAndLimit(@Param("page") int offset, @Param("limit") int limit);
}
