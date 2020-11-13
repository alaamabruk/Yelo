package com.example.demo.yelo.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.yelo.model.Car;
import com.example.demo.yelo.service.CarService;

@RestController
@RequestMapping("/YeloCars")
public class CarController {

	@Autowired
	CarService sr;

	
	@RequestMapping(method = RequestMethod.GET,value="/cars")
	public List<Car> getallCars() {
		return sr.getAlCars();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/car/{id}")
	public Optional<Car> getCar(@PathVariable int id) {
		return sr.getCar(id);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/carsSorted")
	public List<Car> FindCarsSorted() {
		return sr.FindCarsSorted();
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,value="/findCarNameAndOwner")
	public List<Object> findNameAndOwner() {
		return sr.findNameAndOwner();
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value="/car")
	public void addCar(@RequestBody Car car) {
		sr.addCar(car);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/car/{id}")
	public void updateCar(@PathVariable String id,@RequestBody Car car) {
		 sr.updateCar(id,car);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value="/car/{id}")
	public void deleteCar(@PathVariable int id) {
		 sr.deleteCar(id);
	}
	
}
