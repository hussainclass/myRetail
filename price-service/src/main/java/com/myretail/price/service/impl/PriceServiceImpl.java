package com.myretail.price.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.price.entity.Price;
import com.myretail.price.repository.PriceRepository;
import com.myretail.price.repository.impl.PriceRepositoryImpl;
import com.myretail.price.service.PriceService;
 
@Service
public class PriceServiceImpl implements PriceService {
	@Autowired 
	private PriceRepositoryImpl priceRepository;
		
	public PriceServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Price getPriceDetails(Long id) {

		Price price = priceRepository.getPriceDetails(id);
		if (price != null) {
			System.out.println("Price response ...");
			return price;
		}
		return null;
	}
}
