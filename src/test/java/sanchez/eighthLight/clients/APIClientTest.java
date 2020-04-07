package sanchez.eighthLight.clients;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class APIClientTest {

    @Test
    public void testGet(){
        APIClient test = new APIClient(""); //TODO: REMOVE KEY
        String query = "Empire+of+the+summer+moon";

        String result = test.getBooks(query);

        System.out.println(result);
    }
}
