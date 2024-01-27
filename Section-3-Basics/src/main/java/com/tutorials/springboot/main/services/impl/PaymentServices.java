/**
 * 
 */
package com.tutorials.springboot.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorials.springboot.main.repository.dao.IPaymentDAO;
import com.tutorials.springboot.main.services.IPaymentServices;

/**
 * @author Lenovo
 *
 */
@Service
public class PaymentServices implements IPaymentServices {

	@Autowired
	private IPaymentDAO paymentDAO;

	public IPaymentDAO getPaymentDAO() {
		return paymentDAO;
	}

	public void setPaymentDAO(IPaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	@Override
	public void create() {
		paymentDAO.save();
	}

	@Override
	public void update() {
		paymentDAO.update();
	}

	@Override
	public void delete() {
		paymentDAO.delete();
	}

	@Override
	public String get() {
		return paymentDAO.get();
	}

}
