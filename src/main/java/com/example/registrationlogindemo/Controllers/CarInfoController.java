package com.example.registrationlogindemo.Controllers;

import com.example.registrationlogindemo.entity.Car;
import com.example.registrationlogindemo.entity.CarInfo;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.service.CarInfoService;
import com.example.registrationlogindemo.service.CarService;
import com.example.registrationlogindemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


@RequiredArgsConstructor
@Controller
public class CarInfoController {

    @Autowired
    private CarInfoService carInfoService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping("/selection/{car_id}/info")
    public String showCarInfo(@PathVariable("car_id") Long carId, Model model, Principal principal) {
        Car car = carService.getCarById(carId);
        User user = userService.findByEmail(principal.getName());
        CarInfo carInfo = carInfoService.getCarInfoByCarAndUser(car, user);

        carInfo.setCar(car);
        carInfo.setUser(user);

        model.addAttribute("car", car);
        model.addAttribute("carInfo", carInfo);
        return "car-info";
    }

    @PostMapping("/selection/{car_id}/info")
    public String saveAllCarInfo(@PathVariable("car_id") long carId, @ModelAttribute CarInfo carInfo, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        Car car = carService.getCarById(carId);

        carInfo.setUser(user);
        carInfo.setCar(car);
        carInfoService.saveCarInfo(carInfo);
        return "car-info";
    }
}
