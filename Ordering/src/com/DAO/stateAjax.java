package com.DAO;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ServiceSelection;

/**
 * Servlet implementation class stateAjax
 */

public class stateAjax extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	ServiceSelection obj;
	PrintWriter out;
	String stateCode;
	String zipCode;
	List<String> result;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();	// TODO Auto-generated method stub
		obj = new ServiceSelection();
		result = new ArrayList<String>();
		Boolean flag=false;
		stateCode = request.getParameter("state_code");
		zipCode= "*";
		try{
			response.setContentType("text/hrml);characterset=UTF-8");
			result = obj.fetchService(stateCode, zipCode);
			Iterator<String> itr = result.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
				flag=true;
			}
			out.print(flag);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	

}
