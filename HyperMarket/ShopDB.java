package com.zensar.corejava.project1;
import java.sql.*;

public class ShopDB 
{
  public static Connection getConnection()
  throws Exception
  {
	  String driverName = "oracle.jdbc.driver.OracleDriver";
	  Class.forName(driverName);
	  Connection conn = DriverManager.getConnection(
	               "jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
	
	return conn;
  }

}
