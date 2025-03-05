package id.ac.ui.cs.advprog.eshop.car.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.car.model.Car;
import id.ac.ui.cs.advprog.eshop.car.repository.CarRepository;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        carRepository.create(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        Iterator<Car> carIterator = carRepository.findAll();
        List<Car> cars = new java.util.ArrayList<>();
        carIterator.forEachRemaining(cars::add);
        return cars;
    }

    @Override
    public Car findById(String carId) {
        Car car = carRepository.findById(carId);
        return car;
    }

    @Override
    public Car update(Car car) {
        return carRepository.update(car);
    }

    @Override
    public boolean delete(Car car) {
        return carRepository.delete(car);
    }
}
