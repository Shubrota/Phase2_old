package com.ecommerce;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class EProduct {
	private long id;
	private String name;
	private BigDecimal price;
	private Timestamp dateAdded;
	
	public EProduct() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

	public long getId() {
		return id;
	}
	public void setDateAdded(long  id) {
		this.id = id;
	}

	public EProduct(long id, String name, BigDecimal price, Timestamp dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}
	

}
