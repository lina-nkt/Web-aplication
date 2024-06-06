package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("""
                SELECT car
                FROM   Car car
                WHERE  car.makeCar = :makeCar AND car.modelCar = :modelCar
            """)
    Optional<Car> findByMakeAndModel(@Param("makeCar") String makeCar, @Param("modelCar") String modelCar);
}