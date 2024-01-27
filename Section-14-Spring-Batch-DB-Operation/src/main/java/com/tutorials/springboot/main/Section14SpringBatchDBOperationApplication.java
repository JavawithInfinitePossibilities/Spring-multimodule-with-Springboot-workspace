/**
 * 
 */
package com.tutorials.springboot.main;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableBatchProcessing
public class Section14SpringBatchDBOperationApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section14SpringBatchDBOperationApplication.class, args);
	}

}
