package com.example.thread.configuration;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.thread.model.Product;

public class ProductWriter implements ItemWriter<Product> {

	@Override
	public void write(List<? extends Product> products) throws Exception {
		
		products.forEach(t -> {
			System.out.println("Writerr "+t.getName());
		});
		
		
	}
	
	

	

}
