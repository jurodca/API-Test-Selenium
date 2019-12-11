package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import apitest.interfaces.IApiConnect;
import apitest.services.ImplApiConnect;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitionsAPITest 
{
	private IApiConnect apiConnect;
	private String expectedAswer;
	private boolean apiResponse;
	
	@Before
	public void setup() 
	{
		this.apiConnect = new ImplApiConnect();
	}
	
	@Given("^i call the IMDB Movie API$")
	public void i_call_the_IMDB_Movie_API() 
	{
		System.out.println("Connecting to the IMDB Movie API ... ");
	}	
	
	@When("^I enter a movie title with the name (.*) to know if exits$")
	public void i_enter_movie_title(String movieTitle) 
	{
		this.apiResponse = this.apiConnect.searchByTitle(movieTitle);
		if (apiResponse) 
		{
			this.expectedAswer =  "OK";
		} else 
		{
			this.expectedAswer  = "NOT";
		}
	}
	
	@Then("^I expect the response with the expected answer (.*)$")
	public void i_expect_answer(String actualAnswer) 
	{
		assertEquals(this.expectedAswer, actualAnswer);
	}
}
