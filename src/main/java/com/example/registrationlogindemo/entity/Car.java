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

    @ManyToMany
    @JoinTable(
            name="car_cars_info",
            joinColumns={@JoinColumn(name="CAR_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="CARS_INFO_ID", referencedColumnName="ID")})
    public List<CarInfo> carsInfo;

    public Car(String makeCar, String modelCar) {
        this.makeCar = makeCar;
        this.modelCar = modelCar;
    }
}