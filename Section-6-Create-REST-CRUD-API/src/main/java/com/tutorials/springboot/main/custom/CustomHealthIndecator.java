/**
 * 
 */
package com.tutorials.springboot.main.custom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class CustomHealthIndecator implements HealthIndicator {

	@Value("${error.info.status}")
	private boolean error;

	@Override
	public Health health() {
		if (error) {
			System.out.println("Error status : " + error);
			return Health.up().build();
		} else {
			System.out.println("Error status : " + error);
			return Health.down().withDetail("Error Key", 123).build();
		}
	}

}
