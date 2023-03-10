package it.unipv.sfw.trebit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn{
	
	public static Connection startConnection(Connection conn, String schema){
		
        String DbDriver=null;
		String DbURL=null;
		String username=null;
		String password=null;
	
		DbDriver= "com.mysql.cj.jdbc.Driver";
		DbURL= "jdbc:mysql://34.154.88.150:3306/"+schema;
		username="root";
		password ="e";
		
		
		if (isOpen(conn)) {
			closeConnection(conn);
		}
		
		
		try 
		{
			Class.forName(DbDriver);
			conn = DriverManager.getConnection(DbURL, username, password);
			
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		return conn;
		
	}
	
	
	
	
		
	public static boolean isOpen(Connection conn)
		{
			if (conn == null)
				return false;
			else return true;
		}
		
	
	
	
	
	public static Connection closeConnection(Connection conn){
	    	
		if (!isOpen(conn)) {
			return null;
		}
		try
		{
			conn.close();
			conn = null;
			
		}
		catch (SQLException e)
		{
		 e.printStackTrace();
		 return null;
		}
		return conn;
		}
	}
	