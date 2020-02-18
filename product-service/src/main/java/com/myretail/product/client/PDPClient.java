package com.myretail.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(url = "${pdp.url}", name = "pdp-client", fallback = PDPClientFallback.class)
public interface PDPClient {
	
	
    @GetMapping(path = "/v2/pdp/tcin/{productId}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statstics", produces = "application/json")
    public String getProductDetails(@PathVariable("productId") Long productId);

}
