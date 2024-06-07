package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

        public CarInfo(Car car, User user, int mileage, int numberOfOwners, LocalDate lastServiceDate) {
                this.car = car;
                this.user = user;
                this.mileage = mileage;
                this.numberOfOwners = numberOfOwners;
                this.lastServiceDate = lastServiceDate;
        }
}
