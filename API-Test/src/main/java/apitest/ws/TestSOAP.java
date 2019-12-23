package apitest.ws;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class TestSOAP {

	public static void main(String[] args) {
		
		CountryInfoServiceLocator locator = new CountryInfoServiceLocator();
		locator.setCountryInfoServiceSoapEndpointAddress("http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
		
		try {
			
			CountryInfoServiceSoapBindingStub stub = (CountryInfoServiceSoapBindingStub) locator.getPort(CountryInfoServiceSoapType.class);			
			String capital = stub.capitalCity("CO");
			
			System.out.println("La Capital es: "+capital);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException r) {
			r.printStackTrace();
		}
		
	
	}

}
