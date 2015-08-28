package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.factory.Factory;

public class UpdateTable {
	public  static int newInstall(String dueDate1,String orderStatus,String orderType ,String clob1) throws ParseException
	{
		int p=0;
		Factory fc= new Factory();
		Connection conn=fc.createOracleConnection();
		try {
			
			PreparedStatement ps=conn.prepareStatement("insert into customer_orders(customer_id,order_id,order_negotiation_date,order_due_date,order_status,order_xml,order_type ) values(customers_sequence.nextval,order_sequence.nextval,to_date(sysdate,'DD/MM/YYYY'),?,?,?,?)");
			 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		       java.util.Date parsed = format.parse("20110210");
		        java.sql.Date dueDate = new java.sql.Date(parsed.getTime());
			ps.setDate(1,dueDate);
			ps.setString(2,orderStatus);
			ps.setString(3,orderType);
			ps.setString(4,clob1);
			int x= ps.executeUpdate();
			if(x>0)
			{
			System.out.println("Success");
			conn.commit();
		}
			PreparedStatement pm= conn.prepareStatement("select max(customer_id) from customer_orders");
			ResultSet rs= pm.executeQuery();
			 p= rs.getInt(1);
			
		} catch (SQLException f) {
			
			f.printStackTrace();
		}
		return p;
		
	}
}
