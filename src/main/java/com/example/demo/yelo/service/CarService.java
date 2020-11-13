package com.example.demo.yelo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.yelo.model.Car;

public interface CarService {
	
	 public List<Car> getAlCars();
	 public Optional<Car> getCar(int id);
	 public List<Car> FindCarsSorted();
	 public List<Object> findNameAndOwner();
	 public void addCar(Car Car);
	 public void updateCar(String id, Car car);
	 public void deleteCar(int id);

}
