package com.myretail.product.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.myretail.product.entity.Price;


@Component
public class PriceClientFallback implements PriceClient {

	@Override
	public ResponseEntity<Price> getPriceDetails(Long id) {
		Price price = new Price();
		price.setValue(0.0f);
		price.setCurrency_Code("USD");

		return new ResponseEntity<Price>(price, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
