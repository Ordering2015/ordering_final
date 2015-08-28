package ordering;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import disconnectService.*;
/**
 * Servlet implementation class ServiceCustomerId_disconnect
 */
public class ServiceCustomerId_disconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		///SelectServiceDAODisconnectService d=new SelectServiceDAODisconnectService();
		//SelectServiceDAODisconnect wor=d.getSelectServiceDAODisconnectPort();
		SelectServiceDAO_disconnect sd= new SelectServiceDAO_disconnect();
		String cid=request.getParameter("customerId");
		int c=Integer.parseInt(cid);
		List<String> an=sd.getServices(c);
		Iterator<String>  it1 = an.iterator();
		while(it1.hasNext())
			System.out.println(it1.next()); 
		
		HttpSession session1=request.getSession(true);
		session1.setAttribute("att1", an);
		session1.setAttribute("att2", c);
		//response.sendRedirect("RetreiveService.jsp");

		request.getRequestDispatcher("RetreiveService_disconnect.jsp").forward(request,response);

		//PrintWriter out=response.getWriter();
		//out.print(cid);
		//wor.setCustomerId(cid);

	}

}
