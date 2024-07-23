package com.smartschool.springserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String identifier;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school", fetch = FetchType.LAZY)
    private List<Smember> members;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.school")
    private List<SchoolProduct> schoolProducts = new ArrayList<>();

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school", fetch = FetchType.LAZY)
    private List<Order> orders;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school", fetch = FetchType.LAZY)
    private List<LunchRequest> lunchRequests;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Smember> getMembers() {
        return members;
    }

    public void setMembers(List<Smember> members) {
        this.members = members;
    }

    public List<SchoolProduct> getSchoolProducts() {
        return schoolProducts;
    }

    public void setSchoolProducts(List<SchoolProduct> schoolProducts) {
        this.schoolProducts = schoolProducts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<LunchRequest> getLunchRequests() {
        return lunchRequests;
    }

    public void setLunchRequests(List<LunchRequest> lunchRequests) {
        this.lunchRequests = lunchRequests;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
