package com.laptrinhjavaweb.service.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.impl.ProductDAO;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.ProductServiceInterface;

public class ProductServiceImpl implements ProductServiceInterface {

	private ProductDAO p = new ProductDAO();

	@Override
	public List<ProductModel> findAll() {
		return p.findAll();
	}

	@Override
	public ProductModel findOne(Integer id) {
		return p.findByID(id);
	}

	@Override
	public int addProduct(ProductModel pm) {
		try {
			p.insert(pm);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

	@Override
	public int updateProduct(ProductModel pm) {
		try {
			p.update(pm);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;

	}

	@Override
	public int deleteProduct(Integer id) {
		try {
			p.deleteByID(id);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

}
