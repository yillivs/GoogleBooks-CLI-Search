package sanchez.eighthLight.controllers;


import com.google.gson.Gson;
import sanchez.eighthLight.models.Volume;
import sanchez.eighthLight.clients.APIClient;
import sanchez.eighthLight.utilities.JSONUtility;

public class BookController {

    public Volume getBookList(String query){

        JSONUtility jsonUtility = new JSONUtility();
        APIClient booksApiClient = new APIClient(jsonUtility.readApiKey());

        String list = booksApiClient.getBooks(query);

        Volume results = new Gson().fromJson(list, Volume.class);


        return results;
    }

}
