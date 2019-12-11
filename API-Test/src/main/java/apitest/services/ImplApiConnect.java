package apitest.services;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import apitest.interfaces.IApiConnect;
import apitest.utilities.APIConstants;

public class ImplApiConnect implements IApiConnect {
	
	private Response response;
	private OkHttpClient client;
	
	public  ImplApiConnect() {
		client = new OkHttpClient();
	}

	@Override
	public boolean searchByTitle(String title) {
		boolean existsMovie = false;
				
		StringBuilder urlSite = new StringBuilder();
		urlSite.append(APIConstants.URL).append(title);
		 
		try {
			
			HttpResponse<JsonNode> response = Unirest.get(urlSite.toString())
					.header("x-rapidapi-host", APIConstants.HOST)
					.header("x-rapidapi-key", APIConstants.API_KEY)
					.asJson();
			
			String result = response.getBody().getObject().get("Response").toString();
			
			if(result.equals("True")) {
				existsMovie = true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return existsMovie;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public OkHttpClient getClient() {
		return client;
	}

	public void setClient(OkHttpClient client) {
		this.client = client;
	}
	
	
	
	

}
