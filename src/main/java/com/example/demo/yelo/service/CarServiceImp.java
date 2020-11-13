package com.example.demo.yelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.yelo.model.Car;
import com.example.demo.yelo.repository.CarRepository;

@Service
public class CarServiceImp implements CarService {

	@Autowired
	CarRepository repo;
	


	public List<Car> getAlCars() {
		List<Car> Cars=new ArrayList<Car>();
		repo.findAll().forEach(Cars::add);
		return Cars;
	}
	

	
	  public Optional<Car> getCar(int id) { 
		  return repo.findById(id);
	 }
	 

	  public List<Car> FindCarsSorted() { 
		  return repo.findCarsSorted();
	 }
	  
	  
	  public List<Object> findNameAndOwner() {
		    List<Object> Cardata = repo.findNameAndOwner();
		    return Cardata;
		}
	 
	  
	public void addCar(Car Car) {
		
		repo.save(Car);
	}

	public void updateCar(String id, Car car) {
		repo.save(car);
	}

	public void deleteCar(int id) {
	    repo.deleteById(id);	
	}	
	
}
