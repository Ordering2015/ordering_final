package ordering;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.project.SelectServiceDAODisconnect;
import main.project.SelectServiceDAODisconnectService;
import disconnectService.*;
/**
 * Servlet implementation class Update_disconnect
 */
public class Update_disconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cust_id=(int)request.getSession().getAttribute("att2");
		
		PrintWriter out=response.getWriter();
		//SelectServiceDAODisconnectService d1=new SelectServiceDAODisconnectService();
		//SelectServiceDAODisconnect wor1=d1.getSelectServiceDAODisconnectPort();
		SelectServiceDAO_disconnect ss= new SelectServiceDAO_disconnect();
		
		ArrayList<String> disconn_ser_list=new ArrayList<String>();
		String[] services=request.getParameterValues("cb");
		if(services==null){
			response.sendRedirect("RetreiveService_disconnect.jsp");
		}
		else
		{
		for(String s: services)
		{
	//out.print(s);
		disconn_ser_list.add(s);
		System.out.println(s);
		}
		ArrayList<String> ser_id_list=ss.getServiceId(disconn_ser_list);
		Iterator<String>  it3 = ser_id_list.iterator();
		while(it3.hasNext())
			System.out.println(it3.next()); 

		
		
		String s=" ";
		XmlBean_disconnect x=new XmlBean_disconnect();
		Marshal_disconnect m=new Marshal_disconnect();
		String s1 = null;
		while(it3.hasNext())
		{
						
				String current_service_id=it3.next();
					x.setCustomer_id(cust_id);
					System.out.println(cust_id);
					//System.out.println(current_service);
					x.setService_id(current_service_id);
					///System.out.println("xml entered");
					//x.setCustomer_id(123);
					//x.setService_id("12");
					s=s+m.jaxbObjectToXML(x);	
				//
		}	
		 s1=ss.insertOrder(cust_id,s);
		//System.out.println(s);
		
		//String s2=wor1.updateService(disconn_ser_list,cust_id);
		//out.println(s1);
		//out.println(s2);
		request.setAttribute("att3",s1);
		//request.setAttribute("att4",s2);
		request.getRequestDispatcher("Success_disconnect.jsp").forward(request,response);
		//out.print(cust_id);				
		}

	}

}
