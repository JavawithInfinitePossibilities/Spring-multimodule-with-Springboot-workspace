/**
 * 
 */
package com.tutorials.springboot.main.config;

import java.util.Random;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.tutorials.springboot.main.model.Product;

/**
 * @author Lenovo
 *
 */
@Configuration
public class BatchConfig {

	private static Random incrValue = new Random();

	@Autowired
	DataSource datasource;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Bean
	public ItemReader<Product> reader() {
		FlatFileItemReader<Product> flatFileItemReader = new FlatFileItemReader<>();
		ClassPathResource resource = new ClassPathResource("product.csv");
		System.out.println("Path name: " + resource.getPath());
		flatFileItemReader.setResource(resource);

		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<Product>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id", "name", "description", "price");
		BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<Product>();
		fieldSetMapper.setTargetType(Product.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		flatFileItemReader.setLineMapper(lineMapper);
		return flatFileItemReader;
	}

	@Bean
	public ItemProcessor<Product, Product> processer() {
		System.out.println("This is processer:");
		return (p) -> {
			p.setPrice(p.getPrice() - (p.getPrice() * 0.1));
			return p;
		};
	}

	@Bean
	public ItemWriter<Product> writer() {
		JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<Product>();
		writer.setDataSource(datasource);
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		writer.setSql(
				"INSERT INTO product (id,product_name, product_description, product_price) VALUES (:id,:name,:description,:price)");
		return writer;
	}

	/*@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}*/

	@Bean
	public Step step() {
		return stepBuilderFactory.get("Step1").<Product, Product>chunk(2).reader(reader()).processor(processer())
				.writer(writer()).build();
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job" + incrValue.nextInt(10)).incrementer(new RunIdIncrementer()).start(step())
				.build();
	}
}
