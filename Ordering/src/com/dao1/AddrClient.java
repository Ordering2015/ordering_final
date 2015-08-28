package com.dao1;



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
import javax.servlet.http.HttpSession;

import com.model.AddressClass;
import com.DAO.CustDao1;
import com.DAO.DateDao;


/**
 * Servlet implementation class GetDate
 */
public class AddrClient extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws IOException 
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		CustDao1 dao=new CustDao1();
int a=Integer.parseInt(request.getParameter("id"));
		
		
		List<AddressClass> adls1=new ArrayList<AddressClass>();
		adls1=dao.getAddress(1);
		Iterator<AddressClass> it = adls1.iterator();
		AddressClass p;
		while(it.hasNext()){
			p = it.next();
			System.out.println("address id" +p.getAddress_id());
			System.out.println("line1"+p.getAdd_line1());
			System.out.println("line2"+p.getAdd_line2());
			System.out.println("city"+p.getCity());
			System.out.println("state"+p.getState());
			System.out.println("scode"+p.getState_code());
			System.out.println("zcode"+p.getZipcode());
			
		}
		
		//System.out.println(d);
		HttpSession ses=request.getSession(true);
		ses.setAttribute("id1",a);
		request.setAttribute("name", adls1);
		request.getRequestDispatcher("adddisplay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
