package com.dao1;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.factory.Factory;



public class UpdateDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String[] selected = request.getParameterValues("cb");
		
		
		System.out.println("hiiii");
		for(int i=0;i<selected.length;i++)
		{
			
		
			System.out.println("enterd");
		System.out.println("check boxes selected " +selected[i]);
		}
		
		 HttpSession session1 = request.getSession(); 
		 session1.setAttribute("myArray", selected);
		  
		request.getRequestDispatcher("DueDate.jsp").forward(request, response);
		//Factory fc= new Factory();
		//Connection conn= fc.createOracleConnection();
			}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
