package com.laptrinhjavaweb.model;

import java.io.Serializable;

public class ProductModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String img;
	private String name;
	private String description;
	private String content;
	private String price;

	public ProductModel() {
	}

	public ProductModel(Integer id, String name, String img, String description, String content, String price) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.description = description;
		this.content = content;
		this.price = price;
	}

	public ProductModel(String name, String img, String description, String content, String price) {
		super();
		this.name = name;
		this.img = img;
		this.description = description;
		this.content = content;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", img=" + img + ", name=" + name + ", description=" + description
				+ ", content=" + content + ", price=" + price + "]";
	}

}
