/**
 * 
 */
package com.tutorials.springboot.main.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * @author Lenovo
 *
 */
public class ItemWriterCustom implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("Inside writer");
		System.out.println("Write : " + items);
	}

}
