package id.ac.ui.cs.advprog.eshop.car.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.car.model.Car;

@Repository
public class CarRepository {
    static int id = 0;

    private List<Car> carData = new ArrayList<>();

    public Car create(Car car){
        if (car.getCarId() == null) {
            UUID uuid = UUID.randomUUID();
            car.setCarId(uuid.toString());
        }
        carData.add(car);
        return car;
    }

    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    public Car findById(String carId) {
        for (Car car : carData) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
    
    public Car update(Car updatedCar) {
        if (updatedCar == null) {
            return null;
        }

        Car existingCar = findById(updatedCar.getCarId());
        if (existingCar == null) {
            return null;
        }

        existingCar.setCarName(updatedCar.getCarName());
        existingCar.setCarColor(updatedCar.getCarColor());
        existingCar.setCarQuantity(updatedCar.getCarQuantity());
        return existingCar;
    }

    public boolean delete(Car car) {
        return carData.remove(car);
    }
}
