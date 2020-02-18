package com.myretail.price;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretail.price.entity.Price;
import com.myretail.price.repository.impl.PriceRepositoryImpl;
import com.myretail.price.service.impl.PriceServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceServiceMockSpringContextTest {

	@MockBean
	PriceRepositoryImpl priceRepositoryImpl;

	@Autowired
	PriceServiceImpl priceServiceImpl;

	@Test
	public void testGetPriceForTheGivenProduct() {
		when(priceRepositoryImpl.getPriceDetails(13860421l)).thenReturn(new Price(4.22f, "USD"));
		assertEquals(4.22f, priceServiceImpl.getPriceDetails(13860421l).getValue(), 0.0);
	}
	
	@Test
	public void testGetPriceNotFoundForTheGivenProduct() {
		when(priceRepositoryImpl.getPriceDetails(1386l)).thenReturn(null);
		assertNull("Price Not Found for the Product Id " + 1386l, priceServiceImpl.getPriceDetails(1386l));
	}
	
	@Test
	public void testGetPriceNotequalsForTheGivenProduct() {
		when(priceRepositoryImpl.getPriceDetails(13860421l)).thenReturn(new Price(4.22f, "USD"));
		assertNotEquals(10.22f, priceServiceImpl.getPriceDetails(13860421l).getValue(), 0.0);
	}
	
}
