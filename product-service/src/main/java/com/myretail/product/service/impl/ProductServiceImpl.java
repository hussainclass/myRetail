package com.myretail.product.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.product.client.PDPClient;
import com.myretail.product.client.PriceClient;
import com.myretail.product.entity.Price;
import com.myretail.product.entity.Product;
import com.myretail.product.repository.ProductRepository;
import com.myretail.product.service.ProductService;
 
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PDPClient pdpClient;
	
	@Autowired
	private PriceClient priceClient;
	
	
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product getProductDetails(Long id) {

		Product product = null;
		final String productResponse = pdpClient.getProductDetails(id);
				/*restTemplate.getForObject(environment.getProperty("PRODUCT_SERVICE_URL"),
				String.class);*/
		
		System.out.println(productResponse);

		
		final ResponseEntity<Price> priceRespnse = priceClient.getPriceDetails(id);
				/*restTemplate
				.getForEntity(environment.getProperty("PRICE_SERVICE_URL"), Price.class, id);*/

		

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj;
		try {
			if (productResponse != null) {
				product = new Product();
				actualObj = mapper.readTree(productResponse);

				Price price = priceRespnse.getBody();
				JsonNode jsonNodeProdId = actualObj.findValue("product_id");
				JsonNode jsonNodeTitle = actualObj.findValue("title");
				product.setId(jsonNodeProdId.asLong());
				product.setName(jsonNodeTitle.textValue());
				product.setCurrent_price(price);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public boolean updatePrice(Product product) {

		Product productInDB = productRepository.save(product);

		if (productInDB.getId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public Price getPriceDetails(Long id) {

		Price price = productRepository.getPriceDetails(id);
		if (price != null) {
			return price;
		}
		return null;
	}
}
