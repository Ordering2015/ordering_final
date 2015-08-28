package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.factory.Factory;


public class DateDao {
	Connection conn=null;
	int ret;
	PreparedStatement cr;
public DateDao() {
		conn = Factory.createOracleConnection();
	}
public List getdate(String month)
{
	List x=new ArrayList();
	int i=0,y;
	try
	{
	cr=conn.prepareStatement("SELECT Date1 FROM Datevalid WHERE month=? and Availability='y'");
	cr.setString(1, month);
	ResultSet rs=cr.executeQuery();
	while(rs.next())
	{
		x.add(rs.getInt(1));
		i++;
	}
}
catch(SQLException s)
{
	System.out.println(s);
}	
	return x;
}
}


