package com.myretail.product.repository.impl;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import com.myretail.product.entity.Price;
import com.myretail.product.repository.ProductRepositoryCustom;


public class ProductRepositoryImpl implements ProductRepositoryCustom {

	HashMap<Long, Price> map = new HashMap<Long, Price>();

	@PostConstruct
	public void loadProductPriceData() {
		map.put(13860428l, new Price(3.22f, "USD"));
		map.put(13860421l, new Price(4.22f, "USD"));
		map.put(13860422l, new Price(5.22f, "USD"));
	}
	
	public ProductRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Price getPriceDetails(Long id) {
		
		if(map.containsKey(id)){
			return map.get(id);
		}
		return null;
	}
}
