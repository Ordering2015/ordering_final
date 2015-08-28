package Login_Pack;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Password extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PrintWriter out=response.getWriter();
		ResultSet rs=null;
		int Userid=Integer.parseInt(request.getParameter("empid"));
		String unlock=request.getParameter("reset");
		String SecurityQuestion=request.getParameter("securityques");
		String Answer=request.getParameter("answer");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uname = "hr";
			String password = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			 con =  DriverManager.getConnection(url, uname, password);
			 PreparedStatement pstmt;
			 pstmt=con.prepareStatement("select answer from salesrep where empid=?");
			 pstmt.setInt(1, Userid);
			 System.out.println("success");
			 
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String Answer1 = rs.getString(1);
				System.out.println("success1: "+Answer1);
				System.out.println("$"+SecurityQuestion+"$");
				if(Answer.equals(Answer1))
				{
					 pstmt=con.prepareStatement("update salesrep set password=? where securityques=?");
					 pstmt.setString(2,SecurityQuestion);
					 pstmt.setString(1,unlock );
					 int count=pstmt.executeUpdate();
					 con.commit();
					 System.out.println(count);
					 if(count>0){
						 
						 System.out.println("updated.");
						
					 }
				}
				System.out.println("success3");
			}
		}
		catch (ClassNotFoundException e) {
				e.printStackTrace();
		} 
		catch (SQLException e) {
				e.printStackTrace();
		} 
				response.sendRedirect("Login.html");
	}

}
