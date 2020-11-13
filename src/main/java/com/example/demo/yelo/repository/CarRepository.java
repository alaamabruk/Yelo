package com.example.demo.yelo.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.yelo.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {


    
    @Transactional
	@Query(value = "select * from car order by name and model; " , nativeQuery = true)
	public List<Car> findCarsSorted();
   
    
    @Transactional
	@Query(value = "select name, owner from car; " , nativeQuery = true)
	public List<Object> findNameAndOwner();
    
    
}
