package sanchez.eighthLight.controllers;

import org.junit.Test;
import sanchez.eighthLight.models.Book;

import java.util.ArrayList;

public class ReadingListControllerTest {

    @Test
    public void testAddToList(){
        ReadingListController rlController = new ReadingListController();
        String[] a = {"will test"};
        Book testBook = new Book(a,"tested", "test");

        ArrayList<Book> readingList = new ArrayList<>();


    }
}
