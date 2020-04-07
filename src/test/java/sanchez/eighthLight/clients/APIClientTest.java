package sanchez.eighthLight.clients;


import org.junit.Test;
import sanchez.eighthLight.utilities.JSONUtility;

import static org.junit.Assert.assertEquals;

public class APIClientTest {

    @Test
    public void testGet(){
        JSONUtility jsonUtility = new JSONUtility();
        APIClient test = new APIClient(jsonUtility.readApiKey());
        String query = "Empire of the summer moon";

        String result = test.getBooks(query);

        System.out.println(result);
    }
}
