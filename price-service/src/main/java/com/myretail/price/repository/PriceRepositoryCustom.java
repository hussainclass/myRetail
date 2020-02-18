package com.myretail.price.repository;

import org.springframework.stereotype.Repository;

import com.myretail.price.entity.Price;

//@Repository

public interface PriceRepositoryCustom {
	
	public Price getPriceDetails(Long id);


}
