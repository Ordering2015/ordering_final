package com.dao1;
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
import org.tempuri.ArrayOfProductClass;
import org.tempuri.GetAllProducts;
import org.tempuri.GetAllProductsSoap;
import org.tempuri.ProductClass;
import com.factory.Factory;
import com.model.OrderModel;
import com.model.XmlModel;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.factory.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
    @WebService
public class CustomerDao {
	
    	private static final String FILE_NAME = "jaxb-emp.xml";
    	@WebMethod
    	public String getPayMethod(int cid)
    	{
    	Factory_changeorder fc= new Factory_changeorder();
		Connection conn= fc.createOracleConnection();
		String s=null;
		try {
			String Query="select * from customer where custid=?";
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setInt(1,cid);
	        ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				s= rs.getString(2);
			}
			
		} catch (SQLException f) {
			
			f.printStackTrace();
		}	
		return s;	
    	}
    	@WebMethod
    	public int setPayMethod(int cid,String method)
    	{
    	Factory_changeorder fc= new Factory_changeorder();
		Connection conn= fc.createOracleConnection();
		int x=0;
		try {
			String Query="update customer set paymethod=? where custid=?";
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
	
    	public List<ProductClass> getAllProducts(int cid) {
      	  
    		//int end = a.length;
			Set<Integer> set = null;
			List<ProductClass> pdls1 = null;
			try {
				Factory_changeorder fc= new Factory_changeorder();
				Connection conn= fc.createOracleConnection();
				String Query="select * from customer_services where customer_id=?";
				System.out.println("entered");
				PreparedStatement ps=conn.prepareStatement(Query);
				ps.setInt(1,cid);
				ResultSet rs=ps.executeQuery();
				
				ArrayList<Integer> a1=new ArrayList();
				
				int i=0;
				set = new HashSet<Integer>();
				while(rs.next())
				{
					int temp=rs.getInt(2);
					System.out.println("temp"+temp);
					a1.add(temp);
					set.add(temp);
				}   
				
					System.out.println("a  "+a1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			System.out.println("set "+ set);
			Iterator it = set.iterator();
			while(it.hasNext()) {
			
    		GetAllProducts a=new GetAllProducts();
    		GetAllProductsSoap b=a.getGetAllProductsSoap();
    		ArrayOfProductClass s=b.getProductsByServiceID(String.valueOf(it.next()),"NY");
    		//ArrayOfProductClass s=b.getProductsByServiceID("3");
    		pdls1=s.getProductClass();
    		for(ProductClass l:pdls1)
    		{
    			System.out.println(l.getProductDesc());
    			System.out.println(l.getProductID());
    		    System.out.println(l.getServiceID());
    		     System.out.println(l.getProductName());
    		    System.out.println(l.getRate());
    		     System.out.println(l.getProdEffDate());
    		     System.out.println(l.getProdEndDate());
    		}
			}
    		return pdls1;
   
			
			}	
    		/*DbFactory fc= new DbFactory();
    		Connection conn= fc.getOracleCon();
    		Products pds;
    		Products pds1;
    		int servid;
    		List<Products> pdls=new ArrayList<Products>();
    		List<Products> pdls1=new ArrayList<Products>();
    		System.out.println("entering");
    		try {
    			String Query="select * from cust_services where cust_id=?";
    			System.out.println("entered");
    			PreparedStatement ps=conn.prepareStatement(Query);
    			ps.setInt(1,cid);
    			ResultSet rs=ps.executeQuery();
    			
    			ArrayList<Integer> a=new ArrayList();
    			
    			int i=0;
    			//int end = a.length;
    			Set<Integer> set = new HashSet<Integer>();
    			while(rs.next())
    			{
    				int temp=rs.getInt(2);
    				System.out.println("temp"+temp);
    				a.add(temp);
    				set.add(temp);
    			}   
    			
    				System.out.println("a  "+a);
    			
    			
    			
    			System.out.println("set "+ set);
    			Iterator it = set.iterator();
    			
    			while(it.hasNext()) {
    				
    				String Query1="select * from products where service_id=? ";
    				PreparedStatement ps1=conn.prepareStatement(Query1);
    				int e1=(int) it.next();
    				ps1.setInt(1,e1);
    				ResultSet rs1=null;
    				rs1=ps1.executeQuery();
    				
        			while(rs1.next())
        			{
        				System.out.println(rs1.getInt(2));
        				pds1=new Products();
        				pds1.setProduct_id(rs1.getInt(2));
        				pds1.setService_id(rs1.getInt(1));
        				pdls1.add(pds1);
        			}		
    			}
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		System.out.println("All products");
    		Iterator<Products> it = pdls1.iterator();
    		Products p;
    		while(it.hasNext()){
    			p = it.next();
    			System.out.println(p.getProduct_id());
    			
    		}*/
    		
    	
    	public String jaxbObjectToXML(XmlModel x) {
    		try {
    		JAXBContext context = JAXBContext.newInstance(XmlModel.class);
    		Marshaller m = context.createMarshaller();

    		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    		m.marshal(x, new File(FILE_NAME));
    		} catch (JAXBException e) {
    		e.printStackTrace();
    		}
    		
    	String con=" ";
    	final String EoL = System.getProperty("line.separator");
    	List<String> lines;
    	 try{
    	lines = Files.readAllLines(Paths.get(FILE_NAME),
    	Charset.defaultCharset());

    	StringBuilder sb = new StringBuilder();
    	for (String line : lines) {
    	sb.append(line).append(EoL);
    	}
    	final String content = sb.toString();
    	con=content;
    	System.out.println(content);
    	} catch (IOException e) {

    	e.printStackTrace();
    	}
    	
    	return con;
	
}
}