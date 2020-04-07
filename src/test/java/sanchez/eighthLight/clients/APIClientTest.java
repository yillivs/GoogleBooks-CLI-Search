package sanchez.eighthLight.clients;


import org.junit.Test;
import sanchez.eighthLight.controllers.BookController;
import sanchez.eighthLight.models.Volume;

import static org.junit.Assert.assertEquals;

public class APIClientTest {

    @Test
    public void testGet(){
        BookController bookController = new BookController();
        String query = "Empire of the summer moon";

        Volume volume = bookController.getBookList(query);


        assertEquals(volume.getKind(), "books#volume");
    }
}
