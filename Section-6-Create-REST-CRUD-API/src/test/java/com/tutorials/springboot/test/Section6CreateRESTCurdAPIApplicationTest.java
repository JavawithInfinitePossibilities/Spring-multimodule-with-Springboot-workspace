/**
 * 
 */
package com.tutorials.springboot.test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tutorials.springboot.main.Section6CreateRESTCurdAPIApplication;
import com.tutorials.springboot.main.entities.Product;

/**
 * @author Lenovo
 *
 */
@SpringBootTest(classes = Section6CreateRESTCurdAPIApplication.class)
public class Section6CreateRESTCurdAPIApplicationTest {

	@Value("${productrestapi.services.url}")
	private String bashURL;

	@Disabled
	@Test
	void getAllProduct() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> productArr = restTemplate.getForEntity(bashURL + "products/", Product[].class);
		List<Product> products = Arrays.asList(productArr.getBody());
		products.stream().forEach(System.out::println);
	}

	@Disabled
	@Test
	void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(bashURL + "productById/1", Product.class);
		System.out.println("product.getName() :" + product);
	}

	@Disabled
	@Test
	void getProductByName() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> productArr = restTemplate.getForEntity(bashURL + "productByName/vaporizer",
				Product[].class);
		List<Product> products = Arrays.asList(productArr.getBody());
		products.stream().forEach(System.out::println);
	}

	@Disabled
	@Test
	void getProductByNameAndPrice() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> productArr = restTemplate.getForEntity(bashURL + "productByNameAndPrice/Ip&900",
				Product[].class);
		List<Product> products = Arrays.asList(productArr.getBody());
		products.stream().forEach(System.out::println);
	}

	@Disabled("Disable to make the test cases more visible")
	@Test
	void saveProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product("Apple TV", "TV", 5000);
		Product product2 = restTemplate.postForObject(bashURL + "productSave/", product, Product.class);
		System.out.println("product.getName() :" + product2.getName());
	}

	@Disabled
	@Test
	void updateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(bashURL + "product/4", Product.class);
		System.out.println("product.getName() :" + product.getName());
		product.setPrice(2000);
		restTemplate.put(bashURL + "productUpdate/", product);
	}
}
