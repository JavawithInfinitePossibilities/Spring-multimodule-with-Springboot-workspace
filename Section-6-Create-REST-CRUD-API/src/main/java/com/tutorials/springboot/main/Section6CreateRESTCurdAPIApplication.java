/**
 * 
 */
package com.tutorials.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import com.tutorials.springboot.main.config.CacheConfig;

/**
 * @author Lenovo <br/>
 *         This lesson will cover section-7. <br/>
 *         This lesson will cover section-8. <br/>
 *         This lesson will cover section-9. <br/>
 *         http://localhost:8080/productcart/actuator <br/>
 *         http://localhost:8080/productcart/actuator/metrics<br/>
 *         This lesson will cover section-13. <br/>
 *
 */
@SpringBootApplication
@Import(CacheConfig.class)
@EnableCaching
public class Section6CreateRESTCurdAPIApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section6CreateRESTCurdAPIApplication.class, args);
	}

}
