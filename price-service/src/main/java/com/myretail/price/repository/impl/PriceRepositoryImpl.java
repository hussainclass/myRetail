package com.myretail.price.repository.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.myretail.price.entity.Price;
import com.myretail.price.repository.PriceRepositoryCustom;

@Repository

public class PriceRepositoryImpl implements PriceRepositoryCustom {

	Map<Long, Price> map = new ConcurrentHashMap<Long, Price>();

		
	 //Some dummy data
	 
	@PostConstruct
	public void loadProductPriceData() {
		map.put(13860428l, new Price(3.22f, "USD"));
		map.put(13860421l, new Price(4.22f, "USD"));
		map.put(13860422l, new Price(5.22f, "USD"));
	}
	
	public PriceRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Price getPriceDetails(Long id) {
		// Actually this should talk to some database to get all the data
		if(map.containsKey(id)){
			return map.get(id);
		}
		return null;
	}
}
