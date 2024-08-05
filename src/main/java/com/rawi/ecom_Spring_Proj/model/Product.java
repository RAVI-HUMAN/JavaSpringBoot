package com.rawi.ecom_Spring_Proj.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity 														//jpa will consider this class as table
public class Product {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String brand;
	private String category;
	private BigDecimal price;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")        to convert date in proper formate ,letter we did it from the front end side
	private Date releaseDate;
	private Boolean productAvailable;
	private int stockQuantity;
	
	private String imageName;
	private String imageType;
	
	@Lob
	private byte[] imageData;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Boolean getAvailable() {
		return productAvailable;
	}
	public void setAvailable(Boolean available) {
		this.productAvailable = available;
	}
	public int getQuantity() {
		return stockQuantity;
	}
	public void setQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	public Product() {
		
	}
	
	public Product(int id, String name, String description, String brand, String category, BigDecimal price,
			Date releaseDate, Boolean available, int stockQuantity, String imageName, String imageType, byte[] imageData) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.releaseDate = releaseDate;
		this.productAvailable = available;
		this.stockQuantity = stockQuantity;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", category=" + category + ", price=" + price + ", releaseDate=" + releaseDate + ", available="
				+ productAvailable + ", stockQuantity=" + stockQuantity + ", imageName=" + imageName + ", imageType=" + imageType
				+ ", imageData=" + Arrays.toString(imageData) + "]";
	}
	

}
