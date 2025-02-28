package id.ac.ui.cs.advprog.eshop.car.service;

import id.ac.ui.cs.advprog.eshop.car.model.Car;
import id.ac.ui.cs.advprog.eshop.utils.DeleteService;
import id.ac.ui.cs.advprog.eshop.utils.GetService;
import id.ac.ui.cs.advprog.eshop.utils.PostService;
import id.ac.ui.cs.advprog.eshop.utils.UpdateService;

public interface CarService extends GetService<Car>, PostService<Car>, UpdateService<Car>, DeleteService<Car> {}
