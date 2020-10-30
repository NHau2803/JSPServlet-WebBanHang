package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/api-admin" })
public class Api extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private ProductServiceImpl psi = new ProductServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String img = req.getParameter("img");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		String price = req.getParameter("price");

		System.out.println("id: " + id + "-----------");
		System.out.println("name: " + name.trim());
		System.out.println("img: " + img);
		System.out.println("description: " + description);
		System.out.println("content: " + content);
		System.out.println("price: " + price);

		if (id.equals("  ")) {
			System.out.println("add product");
			psi.addProduct(new ProductModel(name, img, description, content, price));

		} else {
			System.out.println("update product");
			psi.updateProduct(
					new ProductModel(Integer.valueOf(id.trim()), name.trim(), img, description, content, price));
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String valueUrl = req.getQueryString();
		System.out.println(valueUrl);
		String arr[] = valueUrl.split(",");
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (String s : arr) {
			try {
				data.add(Integer.valueOf(s));
			} catch (Exception e) {
				data.add(Integer.valueOf(s.split("=")[1]));
			}

		}
		for (int id : data) {
			psi.deleteProduct(id);
		}

	}

}
