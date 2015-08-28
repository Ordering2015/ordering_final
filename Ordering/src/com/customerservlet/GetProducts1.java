package com.customerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tempuri.ArrayOfProductClass;
import org.tempuri.GetAllProducts;
import org.tempuri.GetAllProductsSoap;
import org.tempuri.ProductClass;

/**
 * Servlet implementation class GetProducts
 */
public class GetProducts1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int i = 1;
		String full = " ";
		PrintWriter out = response.getWriter();
		String val = request.getParameter("val");
		GetAllProducts a = new GetAllProducts();
		GetAllProductsSoap b = a.getGetAllProductsSoap();
		ArrayOfProductClass s = b.getProductsByServiceID("1","NY");
		List<ProductClass> p = s.getProductClass();
		System.out.println("working");
		out.println("<br><br><table class=\"vztable\">");
		out.println("<tr><td><b>Product Name</b></td><td><b>Product Description</b></td><td><b>Product Price</b></td></tr>");
		for (ProductClass l : p) {
			out.println("<tr>");
		//	out.println("<div align=\"center\"><div class=\"inputwrap\">");
			out.println("<td><input type=\"checkbox\" id=\"cb" + i
					+ "\" name=\"cb\" value=\""+ l.getProductName()
					+ "\"><label for=\"cb"+i+"\">" + l.getProductName()
					+ "</label></td><td>  "+l.getProductDesc()+"</td><td> $" +l.getRate()+"</td>");
			out.println("</div>");
			out.println("</tr>");
			System.out.println(l.getProductDesc());
			System.out.println(l.getProductID());
			// System.out.println(l.getServiceID());
			System.out.println(l.getProductName());
			System.out.println(l.getProdEffDate());
			System.out.println(l.getProdEndDate());
			full = full + l.getProductName() + "  ";
			i++;
		}
		out.println("<table>");
		out.println("</div>");
		// request.setAttribute("List", full);
		// out.println(full);
		// System.out.println(full);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
