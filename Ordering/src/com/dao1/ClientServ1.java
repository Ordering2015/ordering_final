package com.dao1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.*;
import com.model.AddressClass;


/**
 * Servlet implementation class GetDate
 */
public class ClientServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws IOException 
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		CustDao1 DAO=new CustDao1();
		//CustomerDao dao=new CustomerDao();
		String type1=request.getParameter("type2");
		System.out.println(type1);
		int a=(int) request.getSession(false).getAttribute("id1");
		System.out.println(a);
		int res=DAO.setPMethod(a,type1);
		System.out.println("setMethodStatus:"+res);
		request.setAttribute("name", type1);
		if(res==1)
		{
		request.getRequestDispatcher("Success.jsp").forward(request, response);
		}
		else
		{
		request.getRequestDispatcher("Failure.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
