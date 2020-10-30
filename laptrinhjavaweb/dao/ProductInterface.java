package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface ProductInterface {
	public List<ProductModel> findAll();
	public ProductModel findByID(Integer id);
	public void insert(ProductModel pm);
	public void update(ProductModel pm);
	public void deleteByID(Integer id);

}
