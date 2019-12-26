package stepdefinitions;

import apitest.utilities.DriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StepsDefinitionsLoginTest
{

    WebDriver driver;

    @Before public void setup()
    {
        driver = DriverUtil.getDefaultDriver();
    }

    @After public void tearDown()
    {
        DriverUtil.closeDriver();
    }

    @Given("^I navigate to GitHub website$") public void i_navigate_to_GitHub_website()
    {
        driver.get("https://www.github.com");
    }

    @And("^I click on the Sign in link on homepage$")
    public void i_click_on_the_Sing_in_link_on_homepage()
    throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]")).click();
    }

    @And("^I enter a valid username$") public void i_enter_a_valid_username()
    throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='login_field']")).sendKeys("validUsername");
    }

    @And("^I enter a valid password$") public void i_enter_a_valid_password()
    throws InterruptedException
    {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("validPassword");
    }

    @When("^I click on the Sign in button$") public void i_click_on_the_Sign_in_button()
    throws InterruptedException
    {
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/main/div/form/div[3]/input[8]")).click();
    }

    @Then("^I should be taken to the successful user page$")
    public void i_should_be_taken_to_the_successful_user_page()
    throws InterruptedException
    {
        Thread.sleep(3000);
        WebElement
        exploreGitHubButton =
        driver.findElement(By.xpath("//a[contains(text(),'Explore GitHub')]"));
        Assert.assertTrue(exploreGitHubButton.isDisplayed());
    }
}
