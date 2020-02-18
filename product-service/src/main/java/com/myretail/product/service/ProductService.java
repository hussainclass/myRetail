package com.myretail.product.service;

import com.myretail.product.entity.Price;
import com.myretail.product.entity.Product;

public interface ProductService {
	
	
	public Product getProductDetails(Long id);
	
	public Price getPriceDetails(Long id);
	
	public boolean 	updatePrice(Product product);
	
		
	
}
