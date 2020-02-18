package com.myretail.product.client;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;


@Component
public class PDPClientFallback implements PDPClient {

	@Override
	public String getProductDetails(Long id) {
		
		
		  JsonObject json = new JsonObject();

		    // put some default values for product into the JSON object .
		    json.addProperty("product_id", "1234");
		    json.addProperty("title", "No Name");

		return json.toString();
		
	}

}

