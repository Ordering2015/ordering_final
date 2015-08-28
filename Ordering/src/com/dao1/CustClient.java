package com.dao1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.DAO.CustDao1;




public class CustClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustDao1 dao=new CustDao1();
		int a=Integer.parseInt(request.getParameter("id"));
		String d=dao.getPMethod(a);
		System.out.println(d);
		HttpSession ses=request.getSession(true);
		ses.setAttribute("id1",a);
		request.setAttribute("name", d);
		request.getRequestDispatcher("display.jsp").forward(request, response);

	}

}
