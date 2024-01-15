package com.sms.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDao 
{	
  public Connection getConnection()throws SQLException, ClassNotFoundException
  {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db","root","root");
	  
	  return con;
  }
}
