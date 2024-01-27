/**
 * 
 */
package com.tutorials.springboot.main.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class JmsMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${message.sender.queue}")
	private String queueName;

	public void send(String senderMessage) {
		jmsTemplate.convertAndSend(queueName, senderMessage);
	}
}
