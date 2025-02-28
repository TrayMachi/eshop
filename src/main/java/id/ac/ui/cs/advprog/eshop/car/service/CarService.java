package id.ac.ui.cs.advprog.eshop.car.service;

import id.ac.ui.cs.advprog.eshop.car.model.Car;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.DeleteService;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.GetService;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.PostService;
import id.ac.ui.cs.advprog.eshop.utils.ServiceInterface.UpdateService;

public interface CarService extends GetService<Car>, PostService<Car>, UpdateService<Car>, DeleteService<Car> {}
