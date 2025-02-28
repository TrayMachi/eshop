package id.ac.ui.cs.advprog.eshop.utils;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.car.model.Car;

public interface CarService {
    public Car create(Car car);
    public List<Car> findAll();
    Car findById(String carId);
    public void update(String id, Car car);
    public void deleteCarById(String carId);
}
