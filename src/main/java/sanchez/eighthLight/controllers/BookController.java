package sanchez.eighthLight.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import sanchez.eighthLight.models.Book;
import sanchez.eighthLight.models.GoogleBook;
import sanchez.eighthLight.clients.APIClient;
import sanchez.eighthLight.utilities.JSONUtility;

public class BookController {

    public GoogleBook getBookList(String query){

        JSONUtility jsonUtility = new JSONUtility();
        APIClient booksApiClient = new APIClient(jsonUtility.readApiKey());

        String list = booksApiClient.getBooks(query);

        GoogleBook results = new Gson().fromJson(list,GoogleBook.class);


        return results;
    }

}
