package com.udvot.utils;

public class Product {
	private String productName,thumbImage,price,imageURL,description;
	public Product(String pName, String tImage,String price,String imageURL,String description) {
		this.price = price;
		this.productName = pName;
		this.thumbImage = tImage;
		this.imageURL = imageURL;
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
