package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String makeCar;
    private String modelCar;

    public Car() {
    }

    @OneToMany
    public List<Parts> carParts;

    public Car(String makeCar, String modelCar) {
        this.makeCar = makeCar;
        this.modelCar = modelCar;
    }
}