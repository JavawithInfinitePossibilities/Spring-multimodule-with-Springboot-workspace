/**
 * 
 */
package com.tutorials.springboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.springboot.main.Section12ThymeleafApplication;

/**
 * @author Lenovo
 *
 */
@SpringBootTest(classes = Section12ThymeleafApplication.class)
public class Section12ThymeleafApplicationTest {
	@Test
	void contextLoads() {
		System.out.println("Welcome to spring boot tutorials...");
	}
}
