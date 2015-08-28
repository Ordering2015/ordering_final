package com.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchServices
 */

public class FetchServices extends HttpServlet {
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
		response.flushBuffer();
		out = response.getWriter();	// TODO Auto-generated method stub
		obj = new ServiceSelection();
		result = new ArrayList<String>();
		String services="";
		stateCode = request.getParameter("state_code");
		zipCode= request.getParameter("zip_code");
		try{
			response.setContentType("text/hrml);characterset=UTF-8");
			result = obj.fetchService(stateCode, zipCode);
			Iterator<String> itr = result.iterator();
			while(itr.hasNext()){
				services=services+itr.next()+" ";
			}
			out.print(services);
			
		}
		catch(Exception e){
			
		}
		
	}

}
