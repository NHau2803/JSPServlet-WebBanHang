package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin" })
public class ListController extends HttpServlet {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<ProductModel> list = new ArrayList<ProductModel>();

		ProductServiceImpl p =new ProductServiceImpl();
		list = p.findAll();
		System.out.println(list.toString());
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/list.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
