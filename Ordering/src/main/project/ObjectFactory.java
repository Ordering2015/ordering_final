
package main.project;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the main.project package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetServiceId_QNAME = new QName("http://project.main/", "getServiceId");
    private final static QName _GetServices_QNAME = new QName("http://project.main/", "getServices");
    private final static QName _InsertOrder_QNAME = new QName("http://project.main/", "insertOrder");
    private final static QName _InsertOrderResponse_QNAME = new QName("http://project.main/", "insertOrderResponse");
    private final static QName _GetServiceIdResponse_QNAME = new QName("http://project.main/", "getServiceIdResponse");
    private final static QName _GetServicesResponse_QNAME = new QName("http://project.main/", "getServicesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: main.project
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertOrderResponse }
     * 
     */
    public InsertOrderResponse createInsertOrderResponse() {
        return new InsertOrderResponse();
    }

    /**
     * Create an instance of {@link GetServicesResponse }
     * 
     */
    public GetServicesResponse createGetServicesResponse() {
        return new GetServicesResponse();
    }

    /**
     * Create an instance of {@link GetServiceIdResponse }
     * 
     */
    public GetServiceIdResponse createGetServiceIdResponse() {
        return new GetServiceIdResponse();
    }

    /**
     * Create an instance of {@link GetServiceId }
     * 
     */
    public GetServiceId createGetServiceId() {
        return new GetServiceId();
    }

    /**
     * Create an instance of {@link InsertOrder }
     * 
     */
    public InsertOrder createInsertOrder() {
        return new InsertOrder();
    }

    /**
     * Create an instance of {@link GetServices }
     * 
     */
    public GetServices createGetServices() {
        return new GetServices();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://project.main/", name = "getServiceId")
    public JAXBElement<GetServiceId> createGetServiceId(GetServiceId value) {
        return new JAXBElement<GetServiceId>(_GetServiceId_QNAME, GetServiceId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://project.main/", name = "getServices")
    public JAXBElement<GetServices> createGetServices(GetServices value) {
        return new JAXBElement<GetServices>(_GetServices_QNAME, GetServices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://project.main/", name = "insertOrder")
    public JAXBElement<InsertOrder> createInsertOrder(InsertOrder value) {
        return new JAXBElement<InsertOrder>(_InsertOrder_QNAME, InsertOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://project.main/", name = "insertOrderResponse")
    public JAXBElement<InsertOrderResponse> createInsertOrderResponse(InsertOrderResponse value) {
        return new JAXBElement<InsertOrderResponse>(_InsertOrderResponse_QNAME, InsertOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://project.main/", name = "getServiceIdResponse")
    public JAXBElement<GetServiceIdResponse> createGetServiceIdResponse(GetServiceIdResponse value) {
        return new JAXBElement<GetServiceIdResponse>(_GetServiceIdResponse_QNAME, GetServiceIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServicesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://project.main/", name = "getServicesResponse")
    public JAXBElement<GetServicesResponse> createGetServicesResponse(GetServicesResponse value) {
        return new JAXBElement<GetServicesResponse>(_GetServicesResponse_QNAME, GetServicesResponse.class, null, value);
    }

}
