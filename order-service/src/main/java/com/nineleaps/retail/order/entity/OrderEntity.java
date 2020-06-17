package com.nineleaps.retail.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.datastax.driver.core.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Table("orders")
public class OrderEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private Integer id;
	@Column(value = "date")
	private LocalDate date;
	@Column(value = "customer_name")
	private String customer_name;
	@Column(value = "customer_email")
	private String customer_email;
	@Column(value = "customer_address")
	private String customer_address;

//	@Frozen
	@Column(value = "items")
	@CassandraType(type = Name.INT, userTypeName = "item")
	private Set<Item> items;
	
	@Column(value = "total")
	private Integer total;

	public OrderEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return new Date(java.sql.Date.valueOf(String.valueOf(date)).getTime());
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public void setDate(Date date) {
		this.date = LocalDate.fromMillisSinceEpoch(date.getTime());
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
