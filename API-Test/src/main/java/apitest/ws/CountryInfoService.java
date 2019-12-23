/**
 * CountryInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package apitest.ws;

public interface CountryInfoService extends javax.xml.rpc.Service {

/**
 * This Visual DataFlex Web Service opens up country information.
 * 2 letter ISO codes are used for Country code. There are functions
 * to retrieve the used Currency, Language, Capital City, Continent and
 * Telephone code.
 */
    public java.lang.String getCountryInfoServiceSoapAddress();

    public apitest.ws.CountryInfoServiceSoapType getCountryInfoServiceSoap() throws javax.xml.rpc.ServiceException;

    public apitest.ws.CountryInfoServiceSoapType getCountryInfoServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
