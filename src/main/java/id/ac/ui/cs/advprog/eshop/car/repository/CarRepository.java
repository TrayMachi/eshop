package id.ac.ui.cs.advprog.eshop.car.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.car.model.Car;
import id.ac.ui.cs.advprog.eshop.utils.RepositoryInterface.BaseRepository;

@Repository
public class CarRepository implements BaseRepository<Car> {
    static int id = 0;

    private List<Car> carData = new ArrayList<>();

    public Car create(Car car){
        carData.add(car);
        return car;
    }

    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    public Car findById(String carId) {
        for (Car car : carData) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
    
    public Car update(Car updatedCar) {
        if (updatedCar == null) {
            return null;
        }

        Car existingCar = findById(updatedCar.getId());
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
