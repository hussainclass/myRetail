package com.myretail.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.price.entity.Price;
import com.myretail.price.service.PriceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@RequestMapping("/v1/myretail/")
public class PriceController {

	@Autowired
	private PriceService service;
	
			
	@ApiOperation(value = "get product price details for given product id", tags = "product_price_details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(path = "/price/{productId}", produces = "application/json")
	public ResponseEntity<Price> getPriceDetails(@PathVariable("productId") Long productId) {

		Price price = service.getPriceDetails(productId);
		if (price == null) {
			return new ResponseEntity<Price>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Price>(price, new HttpHeaders(), HttpStatus.OK);
	}

	
}