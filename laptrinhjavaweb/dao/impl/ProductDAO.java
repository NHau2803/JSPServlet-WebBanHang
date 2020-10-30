package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ProductInterface;
import com.laptrinhjavaweb.model.ProductModel;

public class ProductDAO implements ProductInterface {
	private ConnectJDBC con = new ConnectJDBC();

	@Override
	public List<ProductModel> findAll() {
		Connection connection = null;
		Statement statement = null;
		List<ProductModel> list = new ArrayList<>();
		ProductModel p = new ProductModel();
		try {
			connection = con.getConnection();
			String sql = "select * from website.product";
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				p = new ProductModel(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("img"),
						resultSet.getString("description"), resultSet.getString("content"),
						resultSet.getString("price"));

				// System.out.println("id=" + resultSet.getInt("id"));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.closeConnection(statement, connection);
		}
		return list;
	}

	@Override
	public ProductModel findByID(Integer id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ProductModel p = new ProductModel();
		try {
			connection = con.getConnection();
			String sql = "select * from website.product where id = ?";
			statement = connection.prepareCall(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				p = new ProductModel(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("img"),
						resultSet.getString("description"), resultSet.getString("content"),
						resultSet.getString("price"));
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.closeConnection(statement, connection);
		}
		return p;
	}

	@Override
	public void insert(ProductModel pm) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = con.getConnection();
			String sql = "insert into website.product(name, img, description, content , price) values(?, ?, ?, ?, ?)";
			statement = connection.prepareCall(sql);
			statement.setString(1, pm.getName());
			statement.setString(2, pm.getImg());
			statement.setString(3, pm.getDescription());
			statement.setString(4, pm.getContent());
			statement.setString(5, pm.getPrice());
			statement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.closeConnection(statement, connection);
		}

	}

	@Override
	public void update(ProductModel pm) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = con.getConnection();
			String sql = "update website.product set name=?, img=?, description=?, content=?, price=? where id=?";
			statement = connection.prepareCall(sql);
			statement.setString(1, pm.getName());
			statement.setString(2, pm.getImg());
			statement.setString(3, pm.getDescription());
			statement.setString(4, pm.getContent());
			statement.setString(5, pm.getPrice());
			statement.setInt(6, pm.getId());
			statement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.closeConnection(statement, connection);
		}
		
	}

	@Override
	public void deleteByID(Integer id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = con.getConnection();
			String sql = "delete from website.product where id = " + id;
            statement = connection.prepareCall(sql);
            statement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.closeConnection(statement, connection);
		}
		
	}

}
