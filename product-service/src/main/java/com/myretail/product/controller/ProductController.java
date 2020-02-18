package com.myretail.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.product.entity.Product;
import com.myretail.product.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/")
public class ProductController {

	@Autowired
	private ProductService service;

	@ApiOperation(value = "get product details for given product id", tags = "product_details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(path = "/products/{id}", produces = "application/json")
	public ResponseEntity<Product> getProductDetails(@PathVariable("id") Long id) {

		Product product = service.getProductDetails(id);
		if (product == null) {
			return new ResponseEntity<Product>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, new HttpHeaders(), HttpStatus.OK);
	}
		
	@ApiOperation(value = "update price for a product", tags = "price_update")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping(path = "/products/{id}", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> updatePrice(@PathVariable("id") Long id, @RequestBody Product product) {

		if (service.updatePrice(product)) {
			return new ResponseEntity<String>("Product price updated Successfully ", new HttpHeaders(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Price not modified ", new HttpHeaders(), HttpStatus.NOT_MODIFIED);
	}
	
	@ApiOperation(value = "add price for a product", tags = "price_add")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@PutMapping(path = "/products/{id}", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> addPrice(@PathVariable("id") Long id, @RequestBody Product product) {

		if (service.updatePrice(product)) {
			return new ResponseEntity<String>("Product price added Successfully ", new HttpHeaders(),
					HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Price not aded ", new HttpHeaders(), HttpStatus.NOT_IMPLEMENTED);
	}

}