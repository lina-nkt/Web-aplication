package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "carInfo")

public class CarInfo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_car", nullable = false)
        private Car car;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_user", nullable = false)
        private User user;

        @Column(nullable=false)
        private int mileage;
        private int numberOfOwners;
        private LocalDate lastServiceDate;
}
