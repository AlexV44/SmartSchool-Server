package com.smartschool.springserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class OrderProduct {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false)
    private int quantity;

    public OrderProduct() {}

    public OrderProduct(Order order, Product product, int quantity) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }
}
