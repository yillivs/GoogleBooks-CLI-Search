package sanchez.eighthLight.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testBook(){
        String[] author = {"J.K. Rowling"};
        String title = "Harry Potter";
        String publisher = "Bloomsbury Publishing";

        Book testBook1 = new Book(author, "Harry Potter", "Bloomsbury Publishing");

        Book testBook2 = new Book();
        testBook2.setAuthor(author);
        testBook2.setTitle(title);
        testBook2.setPublisher(publisher);

        assertEquals(testBook1.getAuthor(), author);
        assertEquals(testBook1.getPublisher(), publisher);
        assertEquals(testBook1.getTitle(), title);
    }
}
