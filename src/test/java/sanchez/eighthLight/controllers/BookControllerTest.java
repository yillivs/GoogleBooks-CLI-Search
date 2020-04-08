package sanchez.eighthLight.controllers;

import org.junit.Test;
import sanchez.eighthLight.models.Volume;

import static org.junit.Assert.assertEquals;

public class BookControllerTest {

    @Test
    public void testGetBookList(){
        String query = "Empire of the summer moon";

        BookController test = new BookController();

        Volume result =  test.getBookList(query);

        assertEquals(result.getKind(), "books#volumes");
    }
}
