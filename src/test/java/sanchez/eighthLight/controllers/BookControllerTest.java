package sanchez.eighthLight.controllers;


import org.junit.Test;

public class BookControllerTest {

    @Test
    public void testGetBookList(){
        String query = "Empire+of+the+summer+moon";

        BookController test = new BookController();
        String[] result = test.getBookList(query);

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
