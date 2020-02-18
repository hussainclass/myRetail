package com.myretail.product.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myretail.product.entity.Price;



@FeignClient(value = "price-service", fallback = PriceClientFallback.class )
@RibbonClient(name="price-service")
public interface PriceClient {
	
	
	
    //@GetMapping("/product/{productId}/price" )
    @GetMapping(path = "/price/{productId}", produces = "application/json")
    public ResponseEntity<Price> getPriceDetails(@PathVariable("productId") Long id);

}
