package stepdefinitions;

import apitest.utilities.APIConstants;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepsDefinitionsLoginTest {
    WebDriver driver;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", APIConstants.WEBDRIVER);
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
    }

    @Given("^I navigate to GitHub website$")
    public void i_navigate_to_GitHub_website()
    {
        System.out.println("Method 1");
    }

    @And("^I click on the Sing in link on homepage$")
    public void i_click_on_the_Sing_in_link_on_homepage()
    {
        System.out.println("Method 2");
    }

    @And("^I enter a valid username$")
    public void i_enter_a_valid_username()
    {
       System.out.println("Method 3");
    }

    @And("^I enter a valid password$")
    public void i_enter_a_valid_password()
    {
       System.out.println("Method 4");
    }

    @When("^I click on the Sign in button$")
    public void i_click_on_the_Sign_in_button()
    {
      System.out.println("Method 5");
    }

    @Then("^I should be taken to the successful user page$")
    public void i_should_be_taken_to_the_successful_user_page()
    {
       System.out.println("Method 6");
    }
}
