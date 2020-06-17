package com.nineleaps.retail.order.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType(value = "items")
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer product_id;
	private Integer quantity;
	private Integer price;

	public Item() {
		super();
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
