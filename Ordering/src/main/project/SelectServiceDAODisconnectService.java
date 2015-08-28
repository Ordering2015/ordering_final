
package main.project;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SelectServiceDAO_disconnectService", targetNamespace = "http://project.main/", wsdlLocation = "http://192.168.0.61:9412/main.project/greet?wsdl")
public class SelectServiceDAODisconnectService
    extends Service
{

    private final static URL SELECTSERVICEDAODISCONNECTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SELECTSERVICEDAODISCONNECTSERVICE_EXCEPTION;
    private final static QName SELECTSERVICEDAODISCONNECTSERVICE_QNAME = new QName("http://project.main/", "SelectServiceDAO_disconnectService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.61:9412/main.project/greet?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SELECTSERVICEDAODISCONNECTSERVICE_WSDL_LOCATION = url;
        SELECTSERVICEDAODISCONNECTSERVICE_EXCEPTION = e;
    }

    public SelectServiceDAODisconnectService() {
        super(__getWsdlLocation(), SELECTSERVICEDAODISCONNECTSERVICE_QNAME);
    }

    public SelectServiceDAODisconnectService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SELECTSERVICEDAODISCONNECTSERVICE_QNAME, features);
    }

    public SelectServiceDAODisconnectService(URL wsdlLocation) {
        super(wsdlLocation, SELECTSERVICEDAODISCONNECTSERVICE_QNAME);
    }

    public SelectServiceDAODisconnectService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SELECTSERVICEDAODISCONNECTSERVICE_QNAME, features);
    }

    public SelectServiceDAODisconnectService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SelectServiceDAODisconnectService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SelectServiceDAODisconnect
     */
    @WebEndpoint(name = "SelectServiceDAO_disconnectPort")
    public SelectServiceDAODisconnect getSelectServiceDAODisconnectPort() {
        return super.getPort(new QName("http://project.main/", "SelectServiceDAO_disconnectPort"), SelectServiceDAODisconnect.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SelectServiceDAODisconnect
     */
    @WebEndpoint(name = "SelectServiceDAO_disconnectPort")
    public SelectServiceDAODisconnect getSelectServiceDAODisconnectPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://project.main/", "SelectServiceDAO_disconnectPort"), SelectServiceDAODisconnect.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SELECTSERVICEDAODISCONNECTSERVICE_EXCEPTION!= null) {
            throw SELECTSERVICEDAODISCONNECTSERVICE_EXCEPTION;
        }
        return SELECTSERVICEDAODISCONNECTSERVICE_WSDL_LOCATION;
    }

}
