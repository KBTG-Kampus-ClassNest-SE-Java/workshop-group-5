package com.kampus.kbazaar.cart;

import com.google.gson.Gson;
import com.kampus.kbazaar.exceptions.NotFoundException;
import com.kampus.kbazaar.product.Product;
import com.kampus.kbazaar.product.ProductRepository;
import com.kampus.kbazaar.shopper.Shopper;
import com.kampus.kbazaar.shopper.ShopperRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;
    private ShopperRepository shopperRepository;
    private ProductRepository productRepository;

    public CartService(
            CartRepository cartRepository,
            ShopperRepository shopperRepository,
            ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.shopperRepository = shopperRepository;
        this.productRepository = productRepository;
    }

    public String deleteCartItem(String username, String product_sku) {
        return "deleteL: " + username + product_sku;
    }

    public CartResponseDto addCartItem(String username, String product_sku, int quantity) {
        CartResponseDto cartResponseDto = new CartResponseDto();

        Optional<Shopper> shopper = shopperRepository.findByUsername(username);

        if (shopper.isEmpty()) {
            throw new NotFoundException("Invalid request body");
        }

        Optional<Product> product = productRepository.findBySku(product_sku);

        if (product.isEmpty()) {
            throw new NotFoundException("Invalid request body");
        }

        Optional<Cart> cart = cartRepository.findById(shopper.get().getId());

        if (cart.isEmpty()) {
            // First Time

            ProductDatabase productDatabase = new ProductDatabase();

            productDatabase.setSku(product.get().getSku());
            productDatabase.setId(Math.toIntExact(product.get().getId()));
            productDatabase.setQuantity(quantity);

            ArrayList<ProductDatabase> productDatabases = new ArrayList<ProductDatabase>();
            productDatabases.add(productDatabase);

            String jsonList = new Gson().toJson(productDatabases);

            Cart cartNew = new Cart();
            cartNew.setProducts(jsonList);
            cartNew.setShopperId(shopper.get().getId());

            cartRepository.save(cartNew);
            cartRepository.flush();

            cartResponseDto.setUsername(username);

            ArrayList<Item> itemList = new ArrayList<Item>();
            Item item = new Item();

            item.setSku(product_sku);
            item.setName(product.get().getName());
            item.setQuantity(BigDecimal.valueOf(quantity));
            item.setPrice(multiply(quantity, product.get().getPrice()));
            item.setDiscount(BigDecimal.valueOf(0.00));
            item.setFinalPrice(multiply(quantity, product.get().getPrice()));
            itemList.add(item);

            cartResponseDto.setTotalDiscount(BigDecimal.valueOf(0.00));
            cartResponseDto.setTotalPrice(multiply(quantity, product.get().getPrice()));

            cartResponseDto.setItems(itemList);
        } else {

        }

        return cartResponseDto;
    }

    public static BigDecimal multiply(int a, BigDecimal b) {
        return BigDecimal.valueOf(a).multiply(b);
    }
}
