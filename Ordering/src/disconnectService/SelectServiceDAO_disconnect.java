package disconnectService;


	import java.sql.*;
	import java.util.ArrayList;
	import javax.jws.WebMethod;
	import javax.jws.WebService;
import com.factory.Factory_disconnect;

	@WebService
	public class SelectServiceDAO_disconnect {

		public String FILE_NAME="xml";


		@WebMethod
		public ArrayList<String> getServices(int c) 
		{

			ArrayList<String> al=new ArrayList<String>();//creating arraylist  

			Factory_disconnect fc= new Factory_disconnect();

			Connection conn= fc.createOracleConnection();
			try {
				//String Query="select service_name from services d INNER JOIN customer_services s on d.service_id=s.service_id where s.service_current_status!='d' and s.customer_id=?";
				String Query="select service_name from service_description d INNER JOIN customer_services s on d.service_id=s.service_id where s.service_current_status!='d' and s.customer_id=?";
				PreparedStatement ps=conn.prepareStatement(Query);
				ps.setInt(1,c);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					al.add(rs.getString("service_name"));

				} 

			}
			catch (SQLException f)
			{
				f.printStackTrace();
			}
			return al;
		}
		@WebMethod
		public String insertOrder(int c,String s) 
		{

			try
			{

				Factory_disconnect fc= new Factory_disconnect();
				Connection conn= fc.createOracleConnection();
				String s2="select order_sequence.nextval from dual";
				PreparedStatement ps=conn.prepareStatement(s2);
				ResultSet rs=ps.executeQuery();
				int order_id=0;
				while(rs.next())
				{
					order_id=rs.getInt(1);
				}
				System.out.println("order_id:"+order_id);
				String Query="INSERT INTO customer_orders(customer_id,order_id,order_negotiation_date,order_due_date,order_status,order_xml,order_type) VALUES(?,?,sysdate,sysdate+7,'PR',?,'d')";
				PreparedStatement ps1=conn.prepareStatement(Query);
				ps1.setInt(1,c);
				ps1.setInt(2,order_id);
				ps1.setString(3,s);
				ps1.executeUpdate();
				System.out.println("order_xml:"+s);
				conn.commit();
			}
			catch(SQLException f)
			{

				f.printStackTrace();
			}
			String result="Your order has been placed";
			return result;	
		}


		@WebMethod
		public  ArrayList<String> getServiceId(ArrayList<String> al2) 
		{
			
			ArrayList<String> al=new ArrayList<String>();

			Factory_disconnect fc= new Factory_disconnect();
			Connection conn= fc.createOracleConnection();
			try {
				for(int i=0;i<al2.size();i++){
					String s=al2.get(i);
					//String Query="select service_id from services where service_name=?";
					String Query="select service_id from service_description where service_name=?";
					PreparedStatement ps=conn.prepareStatement(Query);
					ps.setString(1,s);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						//System.out.println(rs.getString("service_id"));
						al.add(rs.getString("service_id"));
					} 
				}
			}
			catch(SQLException f) {
				fc.closeOracleCon();
				f.printStackTrace();
			}
			return al;	

		}
	}
	/*@WebMethod
		public String updateService(ArrayList<String> al2,int c) 
		{
			Factory fc= new Factory();

			Connection conn= fc.getOracleCon();
			try {
				List<String> al=al2;
				//Iterator<String> it=al.iterator(); 
				for(int i=0;i<al.size();i++){
				String s=al.get(i);

					String Query="update customer_service set service_current_status='d',service_end_date=sysdate where CUSTOMER_ID=? and service_id=(select service_id from services where service_name=?)";
					PreparedStatement ps=conn.prepareStatement(Query);
					ps.setInt(1,c);
					ps.setString(2,s);

					ps.executeUpdate();
				}
			}
			catch(SQLException f) {
				//fc.closeOracleCon();
				f.printStackTrace();
			}
			String result="Services disconnected Successfully";
			return result;	

		}
	}
	 */

