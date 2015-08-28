package com.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbFactory {
	Connection con=null;
	public Connection getOracleConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost:1521:orcl");
			System.out.println("Connection Established");
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c);
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
		return con;
	}
	public void closeOracleConnection()
	{
		if(con!=null)
			try
		{
				con.close();
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
	}
}
