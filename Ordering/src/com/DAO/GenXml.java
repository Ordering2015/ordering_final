package com.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao1.CustomerDao;
import com.model.XmlModel;


public class GenXml extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenXml() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		final String FILE_NAME = "jaxb-emp.xml";
		String day = request.getParameter("dueDate");
		String month = request.getParameter("mySelect");
		System.out.println(Integer.parseInt(day));
		System.out.println("servlet");
		System.out.println(month);
		int customer_id = (int) request.getSession(false).getAttribute("Name");
		String due_date = "2015" + "/" + month + "/" + day;
		System.out.println("cust id" + customer_id);
		String[] array1 = (String[]) request.getSession(false).getAttribute("myArray");





		for (int i = 0; i < array1.length; i++) {


			System.out.println("enterd");
			System.out.println(array1[i]);
		}
		String order_type = "y";

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date date = new Date();

		System.out.println(dateFormat.format(date));
		XmlModel x = new XmlModel();
		String s1 = "";
		CustomerDao dao = new CustomerDao();
		for (int i = 0; i < array1.length; i++) {
			String curr = array1[i];
			String curr_tokens[] = curr.split(",");
			x.setCustomer_id(customer_id);
			x.setOrder_due_date(due_date);
			x.setService_id(curr_tokens[2]);
			x.setProduct_quantity(1);
			x.setOrder_negotiation_date(dateFormat.format(date));
			x.setProduct_id(curr_tokens[0]);
			x.setProduct_desc(curr_tokens[1]);
			x.setOrder_type("N");
			System.out.println("enterd");
			s1 = s1 + dao.jaxbObjectToXML(x);


		}
		System.out.println(s1);
		CustDao1 dao1 = new CustDao1();
		dao1.insertXml(s1);
		request.getRequestDispatcher("SuccessP.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}