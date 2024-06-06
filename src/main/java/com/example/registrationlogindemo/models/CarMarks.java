/**package com.example.registrationlogindemo.models;

import com.example.registrationlogindemo.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CarMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String brand;

    @Column(nullable=false)
    private String model;

    @ManyToMany(mappedBy = "carMarks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Parts> parts = new ArrayList<>();

    @ManyToMany(mappedBy="cars", fetch = FetchType.LAZY)
    private List<User> users;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}**/
