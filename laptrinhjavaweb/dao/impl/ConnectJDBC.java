package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.common.SystemConstant;
import com.laptrinhjavaweb.dao.ConnectJDBCInterface;

public class ConnectJDBC implements ConnectJDBCInterface{

	@Override
	public Connection getConnection() {
		try {
			Class.forName(SystemConstant.urlDriver);
			return DriverManager.getConnection(SystemConstant.url, SystemConstant.user, SystemConstant.pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeConnection(Statement stm, Connection con) {
		if(stm!=null) {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(con!= null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
