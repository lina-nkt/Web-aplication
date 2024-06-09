package com.example.registrationlogindemo.Controllers;

import com.example.registrationlogindemo.entity.Car;
import com.example.registrationlogindemo.entity.CarInfo;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.CarInfoRepository;
import com.example.registrationlogindemo.service.CarService;
import com.example.registrationlogindemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@Slf4j
public class CarInfoController {

    @Autowired
    private final CarInfoRepository carInfoRepository;
    private final UserService userService;
    private final CarService carService;

    @GetMapping("/selection/{car_id}/info")
    public String carInfo(Model model) {
        return "car-info";
    }

    @PostMapping("/selection/{car_id}/info")
    public String saveCarInfo(@PathVariable("car_id") long carId, @RequestParam int mileage,
                              @RequestParam int numOfOwners, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastServiceDate,
                              Principal principal) {
        User user = userService.findByEmail(principal.getName());
        Car car = carService.getCarById(carId);

        Optional<CarInfo> existingCarInfo = user.getCarsInfo().stream()
                .filter(info -> info.getCar().getId() == carId)
                .findFirst();

        CarInfo carInfo;
        if (existingCarInfo.isPresent()) {
            carInfo = existingCarInfo.get();
            user.getCarsInfo().remove(carInfo);
            carInfo.setMileage(mileage);
            carInfo.setNumberOfOwners(numOfOwners);
            carInfo.setLastServiceDate(lastServiceDate);
            user.getCarsInfo().add(carInfo);

        } else {
            carInfo = new CarInfo(car, user, mileage, numOfOwners, lastServiceDate);
            user.getCarsInfo().add(carInfo);
        }
        carInfoRepository.save(carInfo);

        return "redirect:/selection";
    }
}
