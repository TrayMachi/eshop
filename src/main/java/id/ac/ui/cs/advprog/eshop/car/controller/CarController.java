package id.ac.ui.cs.advprog.eshop.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.advprog.eshop.car.model.Car;
import id.ac.ui.cs.advprog.eshop.car.service.CarServiceImpl;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    private static final String carListUrl = "redirect:/car/list";

    @GetMapping("/create")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "CreateCar";
    }

    @PostMapping("/create")
    public String createCarPost(@ModelAttribute Car car, Model model) {
        carService.create(car);
        return carListUrl;
    }

    @GetMapping("/list")
    public String carListPage(Model model) {
        List<Car> allCars = carService.findAll();
        model.addAttribute("cars", allCars);
        return "CarList";
    }

    @GetMapping("/edit/{id}")
    public String editCarPage(@PathVariable("id") String carId, Model model) {
        Car car = carService.findById(carId);
        model.addAttribute("car", car);
        return "EditCar";
    }

    @PostMapping("/edit")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        carService.update(car.getCarId(), car);
        return carListUrl;
    }

    @PostMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") String carId, Model model) {
        carService.deleteCarById(carId);
        return carListUrl;
    }
}
