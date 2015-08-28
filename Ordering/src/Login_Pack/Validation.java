package Login_Pack;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validation
 */

public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int iter=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PrintWriter out=response.getWriter();
		HttpSession hs=request.getSession();
		String name= request.getParameter("uname");
		int Userid=Integer.parseInt(request.getParameter("empid"));
		String Manname=request.getParameter("manname");
		String Answer=request.getParameter("answer");
		String Password=request.getParameter("password");
		String SecurityQuestion=request.getParameter("securityques");
		String role=request.getParameter("role");
		out.println("your name is "+name+"</br>");
		out.println("your userid is"+Userid+"</br>");
		
		//securityValue=Integer.parseInt(SecurityQuestionValues[0]);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uname = "hr";
			String password = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			 con =  DriverManager.getConnection(url, uname, password);
			 PreparedStatement pstmt;
			 out.println("success");
			pstmt=con.prepareStatement("insert into salesrep values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, Userid);
			pstmt.setString(2, name);
			pstmt.setString(3,Password);
			pstmt.setString(4, Manname);
			pstmt.setString(5, role);
			pstmt.setString(6, SecurityQuestion);
			pstmt.setString(7, Answer);
			
		
			int insertedValues=pstmt.executeUpdate();
			if(insertedValues>0){
				con.commit();
				out.println("values successfully inserted");
				
			
			  response.sendRedirect("Login.html");
				}
			
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		

	}
}

