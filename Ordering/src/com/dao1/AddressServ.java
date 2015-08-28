package com.dao1;
import com.DAO.*;
import com.model.AddressClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GetDate
 */
public class AddressServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws IOException 
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		CustDao1 dao=new CustDao1();
		//CustomerDAO DAO=new CustomerDAO();
		String a1=request.getParameter("a1");
		String a2=request.getParameter("a2");
		String a3=request.getParameter("a3");
		String a4=request.getParameter("a4");
		String a5=request.getParameter("a5");
		String a6=request.getParameter("a6");
		System.out.println("edited addressa1"+a1);
		System.out.println("edited addressa2"+a2);
//		List<AddressClass> ls=new ArrayList<AddressClass>();
		AddressClass temp =new AddressClass();
		temp.setAdd_line1(a1);
		temp.setAdd_line2(a2);
		temp.setCity(a3);
		temp.setState(a4);
		temp.setState_code(a5);
		temp.setZipcode(Integer.parseInt(a6));
		
		int a=(int) request.getSession(false).getAttribute("id1");
		System.out.println("id1"+a);
		int stat=dao.setAddressMethod(a,temp);
		System.out.println("stat"+stat);
		if(stat==1){
		request.getRequestDispatcher("ASuccess.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("Failure.jsp").forward(request, response);
		}
		
	}
	}	
