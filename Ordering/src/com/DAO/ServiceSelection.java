package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ServiceSelection {
	Connection con=null;
	DbFactory db;
	PreparedStatement ps=null;
	ResultSet rs;
	public List<String> fetchService(String stateCode, String zipCode){
		db=new DbFactory();
		con=db.getOracleConnection();
		List<String> services = new ArrayList<String>();;
		try{
			ps=con.prepareStatement("select * from service_availability where state_code = ? and zip_code =?");
			ps.setString(1, stateCode);
			ps.setString(2, zipCode);
			rs= ps.executeQuery();
			while(rs.next())
				services.add(rs.getString("service_name"));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		db.closeOracleConnection();
		return services;
		
	}
}
