/**
 * 
 */
package com.tutorials.springboot.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.springboot.main.Section3BasicsApplication;
import com.tutorials.springboot.main.entities.StudentDB;
import com.tutorials.springboot.main.repository.IStudentRepository;
import com.tutorials.springboot.main.services.Add2Number;
import com.tutorials.springboot.main.services.IPaymentServices;

/**
 * @author Lenovo
 *
 */
@SpringBootTest(classes = Section3BasicsApplication.class)
public class Section3BasicsApplicationTest {

	@Autowired
	private IPaymentServices paymentSrvs;

	@Autowired
	private Add2Number add2Numbers;

	@Autowired
	private IStudentRepository studentRepo;

	@Disabled
	@Test
	void contextLoads() {
		System.out.println("Welcome to spring boot tutorials...");
	}

	@Disabled
	@Test
	void testAdd2Numbers() {
		int result = add2Numbers.addNumber(1, 2);
		System.out.println("Adding of 2 number :" + result);
	}

	@Disabled
	@Test
	void testCreate() {
		paymentSrvs.create();
	}

	@Disabled
	@Test
	void testUpdate() {
		paymentSrvs.update();
	}

	@Disabled
	@Test
	void testDelete() {
		paymentSrvs.delete();
	}

	@Disabled
	@Test
	void testSelect() {
		paymentSrvs.get();
	}

	@Test
	void testSaveStudent() {
		StudentDB studentDB = new StudentDB();
		studentDB.setId(1l);
		studentDB.setName("Siddhant");
		studentDB.setTestScore(100);

		studentRepo.save(studentDB);

		// Select
		StudentDB saveStudent = studentRepo.findById(1l).get();
		System.out.println(saveStudent);

		/*
		// Update
		studentDB.setTestScore(90);
		studentRepo.save(studentDB);
		StudentDB updateStudent = studentRepo.findById(1l).get();
		System.out.println("Updated student :" + updateStudent);
		
		// Delete
		studentRepo.deleteById(1L);
		StudentDB deleteStudent = studentRepo.findById(1l).orElse(null);
		System.out.println("Deleted student:" + deleteStudent);
		*/
	}
}
