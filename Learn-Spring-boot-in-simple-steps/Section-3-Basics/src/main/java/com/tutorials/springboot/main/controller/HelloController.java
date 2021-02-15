/**
 * 
 */
package com.tutorials.springboot.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo<br/>
 *         URL: http://localhost:8080/hello
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String helloSpringBoot() {
		return "This is first spring boot application. Hello spring boot.";
	}
}
