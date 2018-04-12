package com.example.thread.configuration;

import org.springframework.batch.item.ItemProcessor;

import com.example.thread.model.Product;

public class ProductProcessor implements ItemProcessor<Product, Product>{

	@Override
	public Product process(Product product) throws Exception {
		product.setName(product.getName()+" multi threaddd");

		
		return product;
	}

}
