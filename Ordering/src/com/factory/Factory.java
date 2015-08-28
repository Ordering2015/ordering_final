package com.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class Factory {
	static Connection conn=null;
	public static Connection createOracleConnection()
	{
		 
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr" );
			System.out.println("connection established");
	}
		
		catch(SQLException s)
		{
			System.out.println(s);
		}	
		catch(ClassNotFoundException c)
		{
			System.out.println(c);
		}
		return conn;
}
	public void closeOracleCon()
	{
		if(conn!=null)
		{
			try
			{
				conn.close();
			}
			catch(SQLException s)
			{
				System.out.println(s);
			}
		}
	}
}