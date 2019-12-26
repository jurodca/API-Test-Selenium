
package apitest.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.squareup.okhttp.OkHttpClient;
import apitest.interfaces.IApiConnect;
import apitest.utilities.APIConstants;

public class ImplApiConnect implements IApiConnect
{

    private OkHttpClient client;

    public ImplApiConnect()
    {
        client = new OkHttpClient();
    }

    @Override
    public boolean searchByTitle(String title)
    {
        boolean existsMovie = false;
        StringBuilder urlSite = new StringBuilder();
        urlSite.append(APIConstants.URL).append(title);
        try
        {
            HttpResponse<JsonNode> response =
                Unirest
                    .get(urlSite.toString())
                    .header("x-rapidapi-host", APIConstants.HOST)
                    .header("x-rapidapi-key", APIConstants.API_KEY)
                    .asJson();
            String result = response.getBody().getObject().get("Response").toString();
            existsMovie = result.equals("True");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return existsMovie;
    }

    public OkHttpClient getClient()
    {
        return client;
    }

    public void setClient(OkHttpClient client)
    {
        this.client = client;
    }
}
