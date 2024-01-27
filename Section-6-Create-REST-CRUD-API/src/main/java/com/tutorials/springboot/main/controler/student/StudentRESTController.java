/**
 * 
 */
package com.tutorials.springboot.main.controler.student;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.springboot.main.entities.StudentDB;
import com.tutorials.springboot.main.repositories.student.IStudentRepository;

/**
 * @author Lenovo URL :
 *         http://localhost:8080/Studentseminar/Studentdetails/Students/
 *         http://localhost:8080/Studentseminar/Studentdetails/StudentById/2
 *         http://localhost:8080/Studentseminar/Studentdetails/StudentByName/Sid
 *         http://localhost:8080/Studentseminar/Studentdetails/StudentByNameAndScore/Sid&50
 *         http://localhost:8080/Studentapi/Studentdetails/StudentSave/ <br/>
 *         { "id": 4, "name": "Sus", "testScore": 50 }
 *         http://localhost:8080/Studentseminar/Studentdetails/StudentUpdate/
 *
 */
@RestController
@RequestMapping(value = "/Studentdetails")
public class StudentRESTController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentRESTController.class);

	@Autowired
	private IStudentRepository studentRepository;

	@RequestMapping(value = "/Students/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDB> getAllProduct() {
		return studentRepository.findAll();
	}

	@RequestMapping(value = "/StudentById/{id}", method = RequestMethod.GET)
	public StudentDB getProduct(@PathVariable("id") long id) {
		LOGGER.info("Finding Students by id : " + id);
		return studentRepository.findById(id).get();
	}

	@RequestMapping(value = "/StudentByName/{name}", method = RequestMethod.GET)
	public List<StudentDB> getProductByName(@PathVariable("name") String name) {
		LOGGER.info("Finding Students by name : " + name);
		return studentRepository.findByName(name);
	}

	@RequestMapping(value = "/StudentByNameAndScore/{name}&{score}", method = RequestMethod.GET)
	public List<StudentDB> getProductByNameAndPrice(@PathVariable("name") String name,
			@PathVariable("score") int score) {
		LOGGER.info("Finding Students by name : " + name + " and Score :" + score);
		return studentRepository.findByNameLikeAndScore(name, score);
	}

	@RequestMapping(value = "/StudentSave/", method = RequestMethod.POST)
	public StudentDB createProduct(@RequestBody StudentDB product) {
		return studentRepository.save(product);
	}

	@RequestMapping(value = "/StudentUpdate/", method = RequestMethod.PUT)
	public StudentDB updateProduct(@RequestBody StudentDB product) {
		return studentRepository.save(product);
	}

	@RequestMapping(value = "/StudentDelete/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") long id) {
		studentRepository.deleteById(id);
	}
}
