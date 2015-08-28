package com.customerservlet;

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

import com.DAO.DateDao;

/**
 * Servlet implementation class GetDate
 */
public class GetDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		DateDao dd= new DateDao();
		List<Integer> x=new ArrayList();
		int j=0;
		String val = request.getParameter("val");
		System.out.println(val);
		PrintWriter out = response.getWriter();
		x=dd.getdate(val);
			Iterator<Integer> i= x.iterator();
out.println("<select name=\"dueDate\" class=\"select-style\">");
while(i.hasNext())
{
		int a=i.next().intValue();
		out.println("<option value=\""+a+"\">"+a+"</option>");
		System.out.println(a);
}
out.println("</select>");
out.println("</div>");
out.println("</div>");
//		out.println("<div class=\"select-style\"> <br />");
//		out.println("<select>");
//		while(i.hasNext())
//		{	
//				
//					out.println("<option value=\""+i.next()+"\">"+i.next()+"</option>");
//					System.out.println(i.next());
//		}
//				out.println("</select>");
//				out.println("</div>");		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
