package com.example.registrationlogindemo.Controllers;

import com.example.registrationlogindemo.entity.CarInfo;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.entity.Car;
import com.example.registrationlogindemo.repository.CarInfoRepository;
import com.example.registrationlogindemo.repository.UserRepository;
import com.example.registrationlogindemo.service.CarInfoService;
import com.example.registrationlogindemo.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.registrationlogindemo.repository.CarRepository;
import com.example.registrationlogindemo.service.UserService;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SelectionController {

    private final UserService userService;
    private final CarService carService;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final CarInfoRepository carInfoRepository;

    @GetMapping("/selection")
    public String carDetails(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userService.findByEmail(email);
        List<Car> userCars = user.getCars();

        log.info("user cars {}", userCars);

        model.addAttribute("email", user.getEmail());
        model.addAttribute("name", user.getName());
        model.addAttribute("cars", userCars);

        return "selection";
    }

    @GetMapping("/selection/add")
    public String selectionAdd(Model model) {
        return "selection-add";
    }
    @PostMapping("/selection/add")
    public String saveCar(@RequestParam String makeCar, @RequestParam String modelCar, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        Car car = carRepository.findByMakeAndModel(makeCar, modelCar).orElseThrow();
        user.getCars().add(car);
        userRepository.save(user);

        return "redirect:/selection";
    }


    @PostMapping("/selection/{car_id}/deleteCar")
    public String deleteCar(@PathVariable(value = "car_id") long carId, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<Car> userCars = user.getCars();

        // Find the car to delete by ID
        Car carToDelete = userCars.stream()
                .filter(car -> car.getId().equals(carId))
                .findFirst()
                .orElse(null);

        if (carToDelete != null) {
            userCars.remove(carToDelete);
            userRepository.save(user);
            log.info("Car deleted successfully: {}", carToDelete.getId());
        } else {
            log.error("Car with ID {} not found for deletion", carId);
        }

        return "redirect:/selection";
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car-list";
    }
}


