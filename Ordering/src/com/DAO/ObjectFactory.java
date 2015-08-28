
package com.DAO;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dao package. 
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

    private final static QName _NewInstall_QNAME = new QName("http://DAO.com/", "newInstall");
    private final static QName _ParseException_QNAME = new QName("http://DAO.com/", "ParseException");
    private final static QName _NewInstallResponse_QNAME = new QName("http://DAO.com/", "newInstallResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NewInstall }
     * 
     */
    public NewInstall createNewInstall() {
        return new NewInstall();
    }

    /**
     * Create an instance of {@link NewInstallResponse }
     * 
     */
    public NewInstallResponse createNewInstallResponse() {
        return new NewInstallResponse();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewInstall }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://DAO.com/", name = "newInstall")
    public JAXBElement<NewInstall> createNewInstall(NewInstall value) {
        return new JAXBElement<NewInstall>(_NewInstall_QNAME, NewInstall.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://DAO.com/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewInstallResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://DAO.com/", name = "newInstallResponse")
    public JAXBElement<NewInstallResponse> createNewInstallResponse(NewInstallResponse value) {
        return new JAXBElement<NewInstallResponse>(_NewInstallResponse_QNAME, NewInstallResponse.class, null, value);
    }

}
