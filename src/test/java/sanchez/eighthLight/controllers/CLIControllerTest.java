package sanchez.eighthLight.controllers;

import org.junit.Test;
import sanchez.eighthLight.models.Book;
import sanchez.eighthLight.models.Volume;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static sanchez.eighthLight.controllers.CLIController.getBooksFromVolume;

public class CLIControllerTest {

    @Test
    public void testPrintBook(){

    }


    @Test
    public void testCliQuery(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CLIController testController = new CLIController();
        BookController bookController = new BookController();
        }

    @Test
    public void testGetBooksFromVolume() {
        BookController bookController = new BookController();
        Volume testVolume = bookController.getBookList("Harry Potter");

        ArrayList<Book> mockBooks = new ArrayList<>();
        ArrayList<Book> assertionBooks = getBooksFromVolume(testVolume);
        String[] titles = {"Fantastic Beasts and Where to Find Them", "Harry Potter: The Complete Collection (1-7)",
                "Harry Potter and the Goblet of Fire", "Harry Potter and the Philosopher's Stone", "Harry Potter and the Sorcerer's Stone"};
        String[] authors = {"J.K. Rowling Newt Scamander ", "J.K. Rowling ", "J. K. Rowling Mary GrandPré ", " J K Rowling "
                , "J. K. Rowling "};
        String[] publishers = {"Pottermore Publishing", "Pottermore Publishing", "Scholastic Paperbacks", "null", "Arthur A. Levine Books"};
        for (int i = 0; i < 5; i++) {
            ArrayList<String> authorList = new ArrayList<>();
            authorList.add(authors[i]);
            mockBooks.add(new Book(authorList.toArray(new String[authorList.size()]), titles[i], publishers[i]));
        }
        for (int i = 0; i < assertionBooks.size(); i++) {
            assertEquals(assertionBooks.get(i).getTitle(), mockBooks.get(i).getTitle());
        }
    }
}
