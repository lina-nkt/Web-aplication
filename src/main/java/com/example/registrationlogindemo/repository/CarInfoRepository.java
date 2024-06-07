package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Car;
import com.example.registrationlogindemo.entity.CarInfo;
import com.example.registrationlogindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarInfoRepository extends CrudRepository<CarInfo, Long> {

    List<CarInfo> findByCarId(Long carId);

    List<CarInfo> findByUserId(Long userId);

    Optional<CarInfo> findByCarAndUser(Car car, User user);

    void deleteByCarId(Long carId);
}
