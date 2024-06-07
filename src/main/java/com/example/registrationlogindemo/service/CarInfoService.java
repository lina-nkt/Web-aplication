package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.entity.Car;
import com.example.registrationlogindemo.entity.CarInfo;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.CarInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarInfoService {
    private final CarInfoRepository carInfoRepository;

    public List<CarInfo> getCarInfoForUser(Long userId) {
        return carInfoRepository.findByUserId(userId);
    }

    public List<CarInfo> getCarInfoForCar(Long carId) {
        return carInfoRepository.findByCarId(carId);
    }

    public void saveCarInfo(CarInfo carInfo) {
        carInfoRepository.save(carInfo);
    }
    public CarInfo getCarInfoByCarAndUser(Car car, User user) {
        Optional<CarInfo> optionalCarInfo = carInfoRepository.findByCarAndUser(car, user);
        return optionalCarInfo.orElse(null);
    }

    public void deleteCarInfoByCarId(Long carId) {
        carInfoRepository.deleteByCarId(carId);
    }
}
