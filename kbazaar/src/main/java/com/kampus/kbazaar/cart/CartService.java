package com.kampus.kbazaar.cart;

import com.kampus.kbazaar.product.ProductRepository;
import com.kampus.kbazaar.shopper.ShopperRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private ShopperRepository shopperRepository;
    private ProductRepository productRepository;

    public CartService(
            CartRepository cartRepository,
            ShopperRepository shopperRepository,
            ProductRepository productRepository,
            CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.shopperRepository = shopperRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public String deleteCartItem(String username, String product_sku) {
        return "deleteL: " + username + product_sku;
    }

    public CartResponseDto addCartItem(String username, String product_sku, int quantity) {
        List<Item> items =
                new ArrayList<>(
                        List.of(
                                new Item(
                                        "MOBILE-APPLE-IPHONE-12-PRO",
                                        "Apple iPhone 12 Pro",
                                        BigDecimal.valueOf(1),
                                        10000.0,
                                        BigDecimal.valueOf(0),
                                        BigDecimal.valueOf(1)),
                                new Item(
                                        "MOBILE-SAMSUNG-GALAXY-S21-ULTRA",
                                        "Samsung Galaxy S21 Ultra",
                                        BigDecimal.valueOf(2),
                                        2000.0,
                                        BigDecimal.valueOf(0),
                                        BigDecimal.valueOf(2)),
                                new Item(
                                        "MOBILE-GOOGLE-PIXEL-5",
                                        "Google Pixel 5",
                                        BigDecimal.valueOf(3),
                                        1000.0,
                                        BigDecimal.valueOf(0),
                                        BigDecimal.valueOf(3))));
        CartResponseDto resp = new CartResponseDto();
        resp.setItems(items);
        resp.setUsername(username);
        Double totlPrice = 0.0;
        for (Item item : items) {
            totlPrice = totlPrice + item.getPrice();
        }
        resp.setTotalPrice(totlPrice);
        resp.setTotalDiscount(BigDecimal.valueOf(0.0));

        return resp;
    }

    public static BigDecimal multiply(int a, BigDecimal b) {
        return BigDecimal.valueOf(a).multiply(b);
    }
}
