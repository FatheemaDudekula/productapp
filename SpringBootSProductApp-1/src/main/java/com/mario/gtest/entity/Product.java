package com.mario.gtest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private int productCode;
	private String category;
	private String productName;
    private	float price;
	private String dealerName;
	private float UserRating;
	
	public Product(int productCode, String category, String productName, float price, String dealerName,
			float userRating) {
		super();
		this.productCode = productCode;
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.dealerName = dealerName;
		UserRating = userRating;
	}
	

}

