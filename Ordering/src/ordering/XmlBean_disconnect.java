package ordering;



import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@WebService

@XmlRootElement(name = "XmlBean")
@XmlType(propOrder = {"customer_id", "service_id"})
public class XmlBean_disconnect 
{

int customer_id;
String service_id;


public XmlBean_disconnect()
{
	//default constructor
}

public XmlBean_disconnect(int c,String s)
{
	customer_id=c;
	service_id=s;
	
}


@WebMethod
public int getCustomer_id() {
return customer_id;
}
@WebMethod
public void setCustomer_id(int customer_id) {
this.customer_id = customer_id;
}
@WebMethod
public String getService_id() {
return service_id;
}
@WebMethod
public void setService_id(String service_id) {
this.service_id = service_id;
}

}



