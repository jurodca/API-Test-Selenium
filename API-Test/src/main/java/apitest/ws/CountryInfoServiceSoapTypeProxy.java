
package apitest.ws;

public class CountryInfoServiceSoapTypeProxy implements apitest.ws.CountryInfoServiceSoapType
{

    private String _endpoint = null;
    private apitest.ws.CountryInfoServiceSoapType countryInfoServiceSoapType = null;

    public CountryInfoServiceSoapTypeProxy()
    {
        _initCountryInfoServiceSoapTypeProxy();
    }

    public CountryInfoServiceSoapTypeProxy(String endpoint)
    {
        _endpoint = endpoint;
        _initCountryInfoServiceSoapTypeProxy();
    }

    private void _initCountryInfoServiceSoapTypeProxy()
    {
        try
        {
            countryInfoServiceSoapType =
                (new apitest.ws.CountryInfoServiceLocator()).getCountryInfoServiceSoap();
            if (countryInfoServiceSoapType != null)
            {
                if (_endpoint != null)
                    ((javax.xml.rpc.Stub) countryInfoServiceSoapType)
                        ._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
                else
                    _endpoint =
                        (String) ((javax.xml.rpc.Stub) countryInfoServiceSoapType)
                            ._getProperty("javax.xml.rpc.service.endpoint.address");
            }

        }
        catch (javax.xml.rpc.ServiceException serviceException)
        {
        }
    }

    public String getEndpoint()
    {
        return _endpoint;
    }

    public void setEndpoint(String endpoint)
    {
        _endpoint = endpoint;
        if (countryInfoServiceSoapType != null)
            ((javax.xml.rpc.Stub) countryInfoServiceSoapType)
                ._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

    }

    public apitest.ws.CountryInfoServiceSoapType getCountryInfoServiceSoapType()
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType;
    }

    public apitest.ws.TContinent[] listOfContinentsByName()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfContinentsByName();
    }

    public apitest.ws.TContinent[] listOfContinentsByCode()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfContinentsByCode();
    }

    public apitest.ws.TCurrency[] listOfCurrenciesByName()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfCurrenciesByName();
    }

    public apitest.ws.TCurrency[] listOfCurrenciesByCode()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfCurrenciesByCode();
    }

    public java.lang.String currencyName(java.lang.String sCurrencyISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.currencyName(sCurrencyISOCode);
    }

    public apitest.ws.TCountryCodeAndName[] listOfCountryNamesByCode()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfCountryNamesByCode();
    }

    public apitest.ws.TCountryCodeAndName[] listOfCountryNamesByName()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfCountryNamesByName();
    }

    public apitest.ws.TCountryCodeAndNameGroupedByContinent[] listOfCountryNamesGroupedByContinent()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfCountryNamesGroupedByContinent();
    }

    public java.lang.String countryName(java.lang.String sCountryISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.countryName(sCountryISOCode);
    }

    public java.lang.String countryISOCode(java.lang.String sCountryName)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.countryISOCode(sCountryName);
    }

    public java.lang.String capitalCity(java.lang.String sCountryISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.capitalCity(sCountryISOCode);
    }

    public apitest.ws.TCurrency countryCurrency(java.lang.String sCountryISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.countryCurrency(sCountryISOCode);
    }

    public java.lang.String countryFlag(java.lang.String sCountryISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.countryFlag(sCountryISOCode);
    }

    public java.lang.String countryIntPhoneCode(java.lang.String sCountryISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.countryIntPhoneCode(sCountryISOCode);
    }

    public apitest.ws.TCountryInfo fullCountryInfo(java.lang.String sCountryISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.fullCountryInfo(sCountryISOCode);
    }

    public apitest.ws.TCountryInfo[] fullCountryInfoAllCountries()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.fullCountryInfoAllCountries();
    }

    public apitest.ws.TCountryCodeAndName[] countriesUsingCurrency(
        java.lang.String sISOCurrencyCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.countriesUsingCurrency(sISOCurrencyCode);
    }

    public apitest.ws.TLanguage[] listOfLanguagesByName()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfLanguagesByName();
    }

    public apitest.ws.TLanguage[] listOfLanguagesByCode()
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.listOfLanguagesByCode();
    }

    public java.lang.String languageName(java.lang.String sISOCode)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.languageName(sISOCode);
    }

    public java.lang.String languageISOCode(java.lang.String sLanguageName)
    throws java.rmi.RemoteException
    {
        if (countryInfoServiceSoapType == null)
            _initCountryInfoServiceSoapTypeProxy();
        return countryInfoServiceSoapType.languageISOCode(sLanguageName);
    }

}
