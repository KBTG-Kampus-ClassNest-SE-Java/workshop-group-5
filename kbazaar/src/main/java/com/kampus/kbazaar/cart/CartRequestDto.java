package com.kampus.kbazaar.cart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CartRequestDto {

    public CartRequestDto() {}

    @NotNull @Pattern(regexp = "^[.\"a-zA-Z0-9- ]{1,255}$", message = "Invalid Input")
    private String productSku;

    @NotNull @Pattern(regexp = "\\d{6}", message = "Invalid Input")
    private int quantity;

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
