package com.myretail.product.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myretail.product.entity.Price;

@Repository
@Transactional(readOnly = true)
public interface ProductRepositoryCustom {
	
	public Price getPriceDetails(Long id);


}
