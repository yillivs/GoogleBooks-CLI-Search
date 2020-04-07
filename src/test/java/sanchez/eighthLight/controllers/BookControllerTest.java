package sanchez.eighthLight.controllers;

import org.junit.Test;
import sanchez.eighthLight.models.Volume;

public class BookControllerTest {

    @Test
    public void testGetBookList(){
        String query = "Empire of the summer moon";

        BookController test = new BookController();

        Volume result =  test.getBookList(query);

        for(int i = 0; i < result.getItems().length; i++){
            System.out.println(result.getItems()[i].getVolumeInfo().getTitle());
        }



    }
}
