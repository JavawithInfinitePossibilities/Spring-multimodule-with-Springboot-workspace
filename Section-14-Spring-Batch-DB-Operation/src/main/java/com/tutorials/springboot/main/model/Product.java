/**
 * 
 */
package com.tutorials.springboot.main.model;

import java.io.Serializable;

/**
 * @author Lenovo
 *
 */
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String description;
	private double price;

	/**
	 * 
	 */
	public Product() {

	}

	/**
	 * @param name
	 * @param description
	 * @param price
	 */
	public Product(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

}
