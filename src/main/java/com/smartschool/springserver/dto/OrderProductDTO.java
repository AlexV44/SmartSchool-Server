package com.smartschool.springserver.dto;

public class OrderProductDTO extends ProductDTO {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
