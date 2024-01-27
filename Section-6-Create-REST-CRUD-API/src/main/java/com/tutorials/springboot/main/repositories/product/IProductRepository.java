/**
* 
*/
package com.tutorials.springboot.main.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tutorials.springboot.main.entities.Product;

/**
 * @author Lenovo
 *
 */
public interface IProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByName(String name);

	@Query("Select p from product p where product_name like %:name% and price>=:price")
	public List<Product> findByNameLikeAndPrice(@Param("name") String name, @Param("price") double price);

}
