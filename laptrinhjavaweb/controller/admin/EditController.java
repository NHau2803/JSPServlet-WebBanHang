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

@WebServlet(urlPatterns = { "/admin-edit" })
public class EditController extends HttpServlet {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductServiceImpl p =new ProductServiceImpl();
		ProductModel list = new ProductModel();
		String valueUrl = req.getQueryString();
		if(!valueUrl.equals("type=new")) {
			String id = req.getParameter("id");
			list = p.findOne(Integer.valueOf(id));
			System.out.println(list.toString());
		}

		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/edit.jsp");
		rd.forward(req, resp);

	}


}
