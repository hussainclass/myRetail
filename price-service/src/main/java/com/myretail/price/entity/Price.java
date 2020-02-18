package com.myretail.price.entity;

import java.io.Serializable;


public class Price implements Serializable {

	public Price() {
		// TODO Auto-generated constructor stub
	}
	
	public Price(float value,String currency_Code ) {
		this.value = value;
		this.currency_Code = currency_Code;
	}
	
	private float value;
	
	private String currency_Code;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getCurrency_Code() {
		return currency_Code;
	}

	public void setCurrency_Code(String currency_Code) {
		this.currency_Code = currency_Code;
	}

}