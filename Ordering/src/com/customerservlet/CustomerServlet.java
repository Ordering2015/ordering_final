package com.customerservlet;
import org.tempuri.*;

import java.beans.XMLEncoder;

import com.DAO.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.Table1;
import com.customer.Table2;
import com.customer.Table3;
import com.customer.AddressBean;
import com.customer.CustomerBean;
import com.DAO.CreateXML;
import com.DAO.ParseException_Exception;
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_NAME1 = "jaxb-emp.xml";
	private static final String FILE_NAME2 = "jaxb-emp.xml";
	private static final String FILE_NAME3 = "jaxb-emp.xml";
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public Table1 setTable1Values(HttpServletRequest request)
	{
		Table1 t1= new Table1();
		t1.setCustomer_Bill_pay(request.getParameter("paymentmethod"));
		t1.setCustomer_email_id(request.getParameter("Email"));
		t1.setCustomer_fname(request.getParameter("firstName"));
		t1.setCustomer_lname(request.getParameter("lastName"));
		t1.setCustomer_mobile_no(Long.parseLong(request.getParameter("phone")));
		t1.setCustomer_status("Active");
		t1.setCustomer_type("New Order");
		//System.out.println("Inside table1set");
		return t1;		
		
	}
	public Table2 setBAddressValues(HttpServletRequest request)
	{
		Table2 t2= new Table2();
		t2.setAdd_line1(request.getParameter("BAddressLine1"));
		t2.setAdd_line2(request.getParameter("BAddressLine2"));
		t2.setAdd_type("Billing");
		t2.setCity(request.getParameter("BCity"));
		t2.setState(request.getParameter("BState"));
		t2.setState_code(" ");
		t2.setZip_code(Integer.parseInt(request.getParameter("BZipCode")));
		//System.out.println("Inside table 2");
		return t2;
		
	}
	public Table2 setSAddressValues(HttpServletRequest request)
	{
		Table2 t2= new Table2();
		t2.setAdd_line1(request.getParameter("SAddressLine1"));
		t2.setAdd_line2(request.getParameter("SAddressLine2"));
		t2.setAdd_type("Service");
		t2.setCity(request.getParameter("SCity"));
		t2.setState(request.getParameter("SState"));
		t2.setState_code("");
		t2.setZip_code(Integer.parseInt(request.getParameter("SZipCode")));
		return t2;
	}
	 private void table1ToXML(Table1 tb) {
		   
		 try {
         JAXBContext context = JAXBContext.newInstance(CustomerBean.class);
         Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
         m.marshal(tb, new File(FILE_NAME1));
     } catch (JAXBException e) {
         e.printStackTrace();
     }
		 System.out.println("table1 to xml");
 }

	    private  void table2ToXML(Table2 tb) {
	 	        try {
	            JAXBContext context = JAXBContext.newInstance(CustomerBean.class);
	            Marshaller m = context.createMarshaller();
	             m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);	             
	            m.marshal(tb, new File(FILE_NAME2));
	        } catch (JAXBException e) {
	            e.printStackTrace();
	            System.out.println("table2 to xml");
	        }
	    }
	    private  void table3ToXML(Table3 tb) {
 	        try {
            JAXBContext context = JAXBContext.newInstance(CustomerBean.class);
            Marshaller m = context.createMarshaller();
            
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            m.marshal(tb, new File(FILE_NAME3));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
 	        System.out.println("table3 to xml");
    }
	    private String getstring(String a)
	    {
	    	String content="";
	    	String EoL = System.getProperty("line.separator");
	    	List<String> lines;
	    	try {
	    		lines = Files.readAllLines(Paths.get(a),
	    		        Charset.defaultCharset());
	    		StringBuilder sb = new StringBuilder();
	    	for (String line : lines) {
	    	    sb.append(line).append(EoL);
	    	}
	    	content = content+sb.toString();	    	
	    	} catch (IOException e) {
	    		
	    		e.printStackTrace();
	    	}
	    	System.out.println(content+"getstring function");
	    	return content;
	    }
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// setOrderValues(request);
		//System.out.println(setCustomerValues(request));
		String[] check=request.getParameterValues("cb");
		String s1="";
		String dateMonth=request.getParameter("mySelect");
		String datedate=request.getParameter("dueDate");
		//System.out.println(dateMonth);
		//System.out.println(datedate);
		String rdate= dateMonth+"-"+datedate+"-2015";
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
        Date startDate=null;
        /*String newDateString = null;
        try 
        {
            startDate = df.parse(rdate);
            newDateString = df.format(startDate);
            System.out.println(startDate);
        } catch (ParseException e) 
        {
            e.printStackTrace();
        }*/
     	Table1 t1=new Table1();
		Table2 t2=new Table2();
		Table2 t4=new Table2();
		t1= setTable1Values(request);
		t2= setBAddressValues(request);
		t4=setSAddressValues(request);
		//CustomerDaoService cds= new CustomerDaoService();
		//CustomerDao c=cds.getCustomerDaoPort();		 	 
		 GetAllProducts a = new GetAllProducts();
			GetAllProductsSoap b = a.getGetAllProductsSoap();
			
		for(int i=0; i<check.length; i++)
	       {
			String disc=" ";
			String sid=" ";
			ArrayOfProductClass s2 = b.getProductDescriptionByProductName(check[i]);
			List<org.tempuri.ProductClass> p = s2.getProductClass();
			for (org.tempuri.ProductClass l : p) {
				disc=l.getProductDesc();
				sid=l.getProductID();
				}
	            System.out.println(check[i]);
	            Table3 t3= new Table3();
	    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    		Date date = new Date();		
	    		String s= "2015-"+request.getParameter("mySelect")+"-"+request.getParameter("dueDate");
	    		t3.setOrder_due_date(s);
	    		t3.setOrder_negotiation_date(dateFormat.format(date));
	    		t3.setOrder_status("PR");
	    		t3.setOrder_type("N");
	    		t3.setProduct_description(disc);
	    		t3.setProduct_id(sid);
	    		t3.setProduct_name(check[i]);
	    		t3.setProduct_qty("1");
	    		t3.setProduct_start_date(" ");
	    		t3.setService_id(sid);
	    		t3.setService_name("Residential");
	    		t3.setService_end_date("2999/12/31");
	    		s1=s1+CreateXML.getStringTable3(t3);
	        }
		 String m="";
		 try {
				m = CreateXML.getStringTable1(t1)+CreateXML.getStringTable2(t2)+CreateXML.getStringTable2(t4)+s1;
				 StringBuffer sbf = new StringBuffer("<NewDataSet>");
				 sbf.append(System.getProperty("line.separator"));
	             sbf.append(m);
	                sbf.append("</NewDataSet>");
	              	m=sbf.toString();	
	              	
				
			} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			  
			  UpdateTable.newInstall(rdate,"N",m,"Residential");
			  System.out.println(m);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}


