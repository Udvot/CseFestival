package com.udvot.utils;

public class Product {
	private String productName,thumbImage,price;
	public Product(String pName, String tImage,String price) {
		this.price = price;
		this.productName = pName;
		this.thumbImage = tImage;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getThumbImage() {
		return thumbImage;
	}

	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
