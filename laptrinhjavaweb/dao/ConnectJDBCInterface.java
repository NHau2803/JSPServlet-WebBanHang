package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.sql.Statement;

public interface ConnectJDBCInterface {
	
	public Connection getConnection();

    public void closeConnection(Statement stm, Connection con);

}
