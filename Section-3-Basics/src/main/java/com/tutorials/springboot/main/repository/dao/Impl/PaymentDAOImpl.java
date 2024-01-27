/**
 * 
 */
package com.tutorials.springboot.main.repository.dao.Impl;

import org.springframework.stereotype.Repository;

import com.tutorials.springboot.main.repository.dao.IPaymentDAO;

/**
 * @author Lenovo
 *
 */
@Repository
public class PaymentDAOImpl implements IPaymentDAO {

	@Override
	public void save() {
		System.out.println("This is a save method");
	}

	@Override
	public void update() {
		System.out.println("This is a update method");
	}

	@Override
	public void delete() {
		System.out.println("This is a delete method");
	}

	@Override
	public String get() {
		System.out.println("This is a get method");
		return "This is a return value for select method";
	}

}
