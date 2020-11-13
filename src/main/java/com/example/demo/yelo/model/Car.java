package com.example.demo.yelo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column
	private String name;
	@Column
	private String color;
	@Column
	private String model;
	@Column
	private String owner;
	 

	
	public Car() {
	
	}



	public Car(int id, String name, String color, String model, String owner) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.model = model;
		this.owner = owner;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getOwner() {
		return owner;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
   private boolean hideMe() {
    	return false;
}

}
