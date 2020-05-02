package sanchez.eighthLight.controllers;

import org.junit.Test;
import sanchez.eighthLight.models.Book;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static sanchez.eighthLight.controllers.CLIController.printBook;
import static sanchez.eighthLight.controllers.CLIController.printReadingList;

public class CLIControllerTest {

    /**
     * Creates an instance of a book. Tests it's equality against a
     * mock book instance.
     */
    @Test
    public void testPrintBook(){
        String[] authors = {"jk rowling"};
        Book testBook = new Book(authors ,"yo","hey");
        StringBuilder sb = new StringBuilder();

        String result = printBook(testBook);
        sb.append(String.format("Title: '%s'", "yo"));
        sb.append("\nAuthor(s): ");
        for (String author : authors) {
            sb.append(author + " ");
        }
        sb.append(String.format("\nPublisher: '%s'\n-----------\n", "hey"));

        assertEquals(result,sb.toString());
        assertNotEquals(sb.toString(), "Not equal to this");
    }
    @Test
    public void testReadingList(){
        String[] authors1 = {"jk rowling"};
        Book testBook = new Book(authors1 ,"yo","hey");
        String[] authors2 = {"tzu"};
        Book testBook2 = new Book(authors2, "sun", "what");

        ArrayList<Book> mock = new ArrayList<>();
        mock.add(testBook);
        mock.add(testBook2);

        String result = printReadingList(mock);

        String assertion = "Reading List:\n" +
                "Title: 'yo'\n" +
                "Author(s): jk rowling \n" +
                "Publisher: 'hey'\n" +
                "-----------\n" +
                "Title: 'sun'\n" +
                "Author(s): tzu \n" +
                "Publisher: 'what'\n" +
                "-----------\n";

        String inequal = "Reading List:\n" +
                "Title: 'yo'\n" +
                "Author(s): jk rowling \n" +
                "Publisher: 'hey'\n" +
                "-----------\n" +
                "Title: 'sinner'\n" +
                "Author(s): tzu \n" +
                "Publisher: 'what'\n" +
                "-----------\n";

        assertEquals(assertion, result);
        assertNotEquals(inequal, result);
    }

}
