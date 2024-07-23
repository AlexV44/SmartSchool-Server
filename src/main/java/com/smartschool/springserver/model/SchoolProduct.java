package com.smartschool.springserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class SchoolProduct {
    @EmbeddedId
    @JsonIgnore
    private SchoolProductPK pk;
    private int quantity;

    public SchoolProduct() {}

    public SchoolProduct(School school, Product product) {
        pk = new SchoolProductPK();
        pk.setSchool(school);
        pk.setProduct(product);
    }

    public SchoolProductPK getPk() {
        return pk;
    }

    public void setPk(SchoolProductPK pk) {
        this.pk = pk;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
