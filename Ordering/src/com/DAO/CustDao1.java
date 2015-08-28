package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.factory.Factory_changeorder;
import com.model.AddressClass;
import com.model.OrderModel;
import com.model.ProductClass;

    @WebService
public class CustDao1 {
	
	@WebMethod
    	public String getPMethod(int cid)
    	{
		Factory_changeorder fc= new Factory_changeorder();
		Connection conn= fc.createOracleConnection();
		String s=null;
		try {
			
			String Query="select * from customer where customer_id=?";
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setInt(1,cid);
	        ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				s= rs.getString(10);
			}
			
		} catch (SQLException f) {
			
			f.printStackTrace();
		}	
		return s;	
    	}
    	@WebMethod
    	public int setPMethod(int cid,String method)
    	{
    		Factory_changeorder fc= new Factory_changeorder();
		Connection conn= fc.createOracleConnection();
		int x=0;
		try {
			String Query="update customer set bill_payment_method=? where customer_id=?";
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setInt(2,cid);
			ps.setString(1, method);
	        
			 x=ps.executeUpdate();
			System.out.println(x);
		} catch (SQLException f) {
			
			f.printStackTrace();
		}	
    		return x;
    	}
    	
    	@WebMethod
    	public List<AddressClass> getAddress(int cid)
    	{
    		Factory_changeorder fc= new Factory_changeorder();
    		Connection conn= fc.createOracleConnection();
    		AddressClass ads;
    		List<AddressClass> adls1=new ArrayList<AddressClass>();
    		int aid=0;
    		try {
    			String Query="select billing_address_id from customer where customer_id=?";
    			System.out.println("entered");
    			PreparedStatement ps=conn.prepareStatement(Query);
    			ps.setInt(1,cid);
    			ResultSet rs=null;
    			 rs=ps.executeQuery();
    	        while(rs.next())
    	        {
    	        	aid=rs.getInt(1);
    	        }
    	        String Query1="select * from customer_address where address_id=?";
				PreparedStatement ps1=conn.prepareStatement(Query1);
				ps1.setInt(1,aid);
				ResultSet rs1=null;
				rs1=ps1.executeQuery();
				
    			while(rs1.next())
    			{
    				System.out.println(rs1.getInt(1));
    				AddressClass ads1=new AddressClass();
    				ads1.setAddress_id(rs1.getInt(1));
    				ads1.setAdd_line1(rs1.getString(2));
    				ads1.setAdd_line2(rs1.getString(3));
    				ads1.setCity(rs1.getString(4));
    				ads1.setState(rs1.getString(5));
    				ads1.setState_code(rs1.getString(6));
    				ads1.setZipcode(rs1.getInt(7));
    				adls1.add(ads1);
    			}	
    		}
    			catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		Iterator<AddressClass> it = adls1.iterator();
        		AddressClass p;
        		/*while(it.hasNext()){
        			p = it.next();
        			System.out.println("address id" +p.getAddress_id());
        			System.out.println("line1"+p.getAdd_line1());
        			System.out.println("line2"+p.getAdd_line2());
        			System.out.println("city"+p.getCity());
        			System.out.println("state"+p.getState());
        			System.out.println("scode"+p.getState_code());
        			System.out.println("zcode"+p.getZipcode());
        			
        		}*/
        		return adls1;
    		
    		 
    		}
    	@WebMethod
    	public int setAddressMethod(int cid,AddressClass al)
    	{
    		Factory_changeorder fc= new Factory_changeorder();
    		Connection conn= fc.createOracleConnection();
    		int x=0;
    		int x1=0;
    		try {
    			String s1="select address_seq.nextval from dual";
    			PreparedStatement ps2=conn.prepareStatement(s1);
    			ResultSet rs=ps2.executeQuery();
    			int adr_id=0;
    			while(rs.next())
    			{
    				adr_id=rs.getInt(1);
    			}
                
    			String Query1="insert into customer_address values (?,?,?,?,?,?,?)"; 
    			PreparedStatement ps1=conn.prepareStatement(Query1);
    			ps1.setInt(1, adr_id);
    			ps1.setString(2, al.getAdd_line1());
    			ps1.setString(3, al.getAdd_line2());
    			ps1.setString(4, al.getCity());
    			ps1.setString(5, al.getState());
    			ps1.setString(6, al.getState_code());
    			ps1.setInt(7, al.getZipcode());
    		
    			 x1=ps1.executeUpdate();
    			 conn.commit();
    			 System.out.println("status address"+x1);
    			 
    			 
    			 
    			 String Query="update customer set billing_address_id=? where customer_id=?";
     			PreparedStatement ps=conn.prepareStatement(Query);
     			
     			ps.setInt(2,cid);
     			ps.setInt(1,adr_id);
     	        
     			 x=ps.executeUpdate();
     			System.out.println("cust status"+x);
    		
    		} catch (SQLException f) {
    			
    			f.printStackTrace();
    		}	
    		
    		return x1;
    	}
        
    	@WebMethod
    	public int insertXml(String s)
    	{
    		int x=0;
    		 try {
    			 Factory_changeorder fc= new Factory_changeorder();
    	         Connection conn= fc.createOracleConnection();
    	         String s2="select order_sequence.nextval from dual";
     			PreparedStatement ps2=conn.prepareStatement(s2);
     			ResultSet rs=ps2.executeQuery();
     			int order_id=0;
     			while(rs.next())
     			{
     				order_id=rs.getInt(1);
     			}
     			System.out.println("order_id"+order_id);
    	    	 String sql = "insert into customer_orders (order_id,order_xml,order_type) values(?,?,?)";
				 PreparedStatement ps=conn.prepareStatement(sql);
				 ps.setInt(1, order_id);
				 ps.setString(2, s);
				 ps.setString(3, "C");
				  x=ps.executeUpdate();
				 conn.commit();
				 System.out.println("ordertablestatus:"+x);
				
				 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
    		 return x;
    	}
    	
    	@WebMethod
    	public List<ProductClass> getSProducts(int cid) {
    		Factory_changeorder fc= new Factory_changeorder();
    		Connection conn= fc.createOracleConnection();
    		com.model.ProductClass pds;
    		List<com.model.ProductClass> pdls1=new ArrayList<com.model.ProductClass>();
    		System.out.println("entering");
    		try {
    			String Query="select service_id from customer_services where customer_id=?";
    			System.out.println("entered");
    			PreparedStatement ps=conn.prepareStatement(Query);
    			ps.setInt(1,cid);
    			ResultSet rs=null;
    			 rs=ps.executeQuery();
    			 ArrayList<Integer> a=new ArrayList();
     			
     			int i=0;
    
     			Set<Integer> set = new HashSet<Integer>();
     			while(rs.next())
     			{
     				int temp=Integer.parseInt(rs.getString(1));
     				System.out.println("temp"+temp);
     				a.add(temp);
     				set.add(temp);
     			}   
     			
     				System.out.println("a  "+a);
    			
     	  			System.out.println("set "+ set);
        			Iterator it = set.iterator();
        			
        			while(it.hasNext()) {
        				
        				String Query1="select service_id,product_id,product_description from product_services where service_id=?";
        				PreparedStatement ps1=conn.prepareStatement(Query1);
        				int e1=(int) it.next();
        				ps1.setInt(1,e1);
        				ResultSet rs1=null;
        				rs1=ps1.executeQuery();
        				
            			while(rs1.next())
            			{
            				System.out.println(rs1.getInt(1));
            				ProductClass pds1=new ProductClass();
            				pds1.setProduct_id(rs1.getInt(2));
            				pds1.setService_id(rs1.getInt(1));
            							pdls1.add(pds1);
            			}		
        			}
     				
     				
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		Iterator<com.model.ProductClass> it = pdls1.iterator();
    		com.model.ProductClass p;
    		while(it.hasNext()){
    			p = it.next();
    			System.out.println(p.getProduct_id());
    			
    		}
    		return pdls1;
    	}
	  
    	
  
    	
    	}