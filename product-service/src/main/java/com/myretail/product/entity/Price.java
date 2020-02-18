package com.myretail.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price implements Serializable {

	private static final long serialVersionUID = 1L;

	public Price() {
		// TODO Auto-generated constructor stub
	}

	public Price(float value, String currency_Code) {
		this.value = value;
		this.currency_Code = currency_Code;
	}

	@Column(name = "value")
	private float value;

	@Column(name = "currency_Code")
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