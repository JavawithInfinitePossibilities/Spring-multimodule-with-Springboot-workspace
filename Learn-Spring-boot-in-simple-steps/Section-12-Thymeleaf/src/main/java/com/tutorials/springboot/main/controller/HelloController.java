/**
 * 
 */
package com.tutorials.springboot.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.springboot.main.model.Student;

/**
 * @author Lenovo <br/>
 *         URL: http://localhost:8080/studentseminar/student
 *         http://localhost:8080/studentseminar/students
 *         http://localhost:8080/studentseminar/studentform
 *
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/senddata")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("Message", "Take up one idea and make it your life");
		return mav;
	}

	@RequestMapping("/student")
	public ModelAndView studentDetail() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setId(1);
		student.setName("Sid");
		student.setScore(100.0);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping("/students")
	public ModelAndView studentDetails() {
		ModelAndView mav = new ModelAndView("studentdetails");
		Student student = new Student();
		student.setId(1);
		student.setName("Sid");
		student.setScore(100.0);

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Sus");
		student2.setScore(100.0);

		List<Student> students = Arrays.asList(student, student2);

		mav.addObject("students", students);
		return mav;
	}

	@RequestMapping("/studentform")
	public ModelAndView displayStudentDetail(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("studentsubmit");
		/*student.setId(1);
		student.setName("Sid");
		student.setScore(100.0);*/
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping("/studentsave")
	public ModelAndView saveStudentDetail(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(student);
		return mav;
	}
}
