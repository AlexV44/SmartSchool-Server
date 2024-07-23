package com.smartschool.springserver.dto;

import com.smartschool.springserver.model.Smember;

import java.util.List;

public class OrderDTO {
    private int id;
    private List<OrderProductDTO> products;
    private int memberId;
    private int schoolId;
    private String time;

    public List<OrderProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProductDTO> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
