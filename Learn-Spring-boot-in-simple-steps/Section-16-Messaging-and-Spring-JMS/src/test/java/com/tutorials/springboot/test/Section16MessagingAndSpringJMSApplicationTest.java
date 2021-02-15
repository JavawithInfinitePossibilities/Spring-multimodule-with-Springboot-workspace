/**
 * 
 */
package com.tutorials.springboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.springboot.main.Section16MessagingAndSpringJMSApplication;
import com.tutorials.springboot.main.sender.JmsMessageSender;

/**
 * @author Lenovo
 *
 */
@SpringBootTest(classes = Section16MessagingAndSpringJMSApplication.class)
public class Section16MessagingAndSpringJMSApplicationTest {

	@Autowired
	private JmsMessageSender sender;

	@Test
	void jmsSendAndReceive() {
		sender.send("Hi this is JMS message!!!");
	}

}
