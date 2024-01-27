/**
 * 
 */
package com.tutorials.springboot.main.controler.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.springboot.main.entities.Product;
import com.tutorials.springboot.main.repositories.product.IProductRepository;

/**
 * @author Lenovo URL :
 *         http://localhost:8080/productcart/productdetails/products/
 *         http://localhost:8080/productcart/productdetails/productById/2
 *
 */
@RestController
@RequestMapping(value = "/productdetails")
public class ProductRESTController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRESTController.class);

	@Autowired
	private IProductRepository productRepository;

	@RequestMapping(value = "/products/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public List<Product> getAllProduct() {
		List<Product> findAll = productRepository.findAll();
		LOGGER.info("Product details: " + findAll);
		return findAll;
	}

	@RequestMapping(value = "/productById/{id}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding product by id : " + id);
		return productRepository.findById(id).get();
	}

	@RequestMapping(value = "/productByName/{name}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public List<Product> getProductByName(@PathVariable("name") String name) {
		LOGGER.info("Finding product by name : " + name);
		return productRepository.findByName(name);
	}

	@RequestMapping(value = "/productByNameAndPrice/{name}&{price}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public List<Product> getProductByNameAndPrice(@PathVariable("name") String name,
			@PathVariable("price") double price) {
		LOGGER.info("Finding product by name : " + name + " and Price :" + price);
		return productRepository.findByNameLikeAndPrice(name, price);
	}

	@RequestMapping(value = "/productSave/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@RequestMapping(value = "/productUpdate/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@RequestMapping(value = "/productDelete/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteById(id);
	}
}
