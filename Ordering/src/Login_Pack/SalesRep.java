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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SalesRep
 */
public class SalesRep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesRep() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		// TODO Auto-generated method stub
		 HttpSession hs=request.getSession();	
		PrintWriter out=response.getWriter();
        String uname=request.getParameter("name");
		String pass=request.getParameter("password");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			PreparedStatement pstmnt=con.prepareStatement("select empid,password,name from salesrep where empid=? and password=?");
			pstmnt.setString(1, uname);
			pstmnt.setString(2, pass);
			String rname="none",rpassword="fail";
//			System.out.println(uname+" "+pass);
			ResultSet rs=pstmnt.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				hs.setAttribute("session_name", rs.getString(3).toUpperCase());
				response.sendRedirect("index-2.html");
				 hs.setAttribute("user_name", rs.getString(3));
			}
			else
			{
				response.sendRedirect("doLogin.html");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


}}
