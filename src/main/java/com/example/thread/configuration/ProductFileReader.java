package com.example.thread.configuration;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.example.thread.model.Product;


public class ProductFileReader extends FlatFileItemReader<Product> {

	public ProductFileReader() {
		
		this.setResource(new ClassPathResource("sample-data.csv"));
		this.setLineMapper(new DefaultLineMapper<Product>() {
			{
				
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setDelimiter("\t");
						setNames(new String[] { "id", "name", "quantity" });
					}
					
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {
					{
						setTargetType(Product.class);
					}
				});
			}
		});
	}


}
