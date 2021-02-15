/**
 * 
 */
package com.tutorials.springboot.main.mylistener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class MyMessageListener {

	@JmsListener(destination = "${message.sender.queue}")
	public void myMessageListenerParty(String message) {
		System.out.println("My message :" + message);
	}
}
