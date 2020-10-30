package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface ProductServiceInterface {
	public List<ProductModel> findAll();
	public ProductModel findOne(Integer id);
	public int addProduct(ProductModel pm);
	public int updateProduct(ProductModel pm);
	public int deleteProduct(Integer id);

}
