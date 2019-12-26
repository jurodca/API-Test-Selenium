
package stepdefinitions;

import apitest.utilities.APIConstants;
import apitest.ws.CountryInfoServiceLocator;
import apitest.ws.CountryInfoServiceSoapBindingStub;
import apitest.ws.CountryInfoServiceSoapType;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class StepsDefinitionsSOAPTest
{

    private CountryInfoServiceSoapBindingStub stub;
    private CountryInfoServiceLocator locator;
    private String capitalCity;

    @Before
    public void setup()
    {
        this.locator = new CountryInfoServiceLocator();
        locator.setCountryInfoServiceSoapEndpointAddress(APIConstants.WS_SOAP_URL_ENDPOINT);
    }

    @Given("^I connect to the SOAP endpoint$")
    public void i_connect_to_the_SOAP_endpoint()
    {
        if (stub == null)
        {
            try
            {
                this.stub =
                    (CountryInfoServiceSoapBindingStub) locator
                        .getPort(CountryInfoServiceSoapType.class);
            }
            catch (ServiceException e)
            {
                e.printStackTrace();
            }
        }
    }

    @When("^I fill a ISO Country code with (.*)$")
    public void i_fill_a_ISO_Country_code_with(String isoCode)
    {
        try
        {
            this.capitalCity = stub.capitalCity(isoCode);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Then("^I validate if the capital name (.*) is correct$")
    public void i_validate_if_the_capital_name_is_correct(String expectedCapital)
    {
        Assert.assertEquals(expectedCapital, this.capitalCity);
    }

}
