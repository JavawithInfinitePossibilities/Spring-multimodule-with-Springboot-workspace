/**
 * 
 */
package com.tutorials.springboot.main;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableBatchProcessing
public class Section14SpringBatchApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section14SpringBatchApplication.class, args);
	}

}
