package sanchez.eighthLight.controllers;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sanchez.eighthLight.models.Book;
import sanchez.eighthLight.clients.APIClient;

public class BookController {

    public String[] getBookList(String query){
        APIClient booksApiClient = new APIClient("AIzaSyDBycFB92OCbsj6Rka4s7zLr80OmOowTcM"); //TODO: REMOVE THE KEY
        String list = booksApiClient.getBooks(query);

        ObjectMapper mapper = new ObjectMapper();

        try {
            Book[] results = mapper.readValue(list, Book[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
