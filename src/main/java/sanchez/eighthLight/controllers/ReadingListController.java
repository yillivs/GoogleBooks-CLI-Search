package sanchez.eighthLight.controllers;


import sanchez.eighthLight.models.Book;

import java.util.ArrayList;

/**
 * Controller for reading list manipulation.
 */
public class ReadingListController {

    /**
     * Method returns book that user selected.
     * @param books list of books from response
     * @param input user input
     * @return book that the user selected
     */
    public Book getReadingListSelection(ArrayList<Book> books, int input){
        Book result = new Book();
        if(input >= 0 && input < 5){
            result = books.get(input);
        }
        else if(input == 5){
            System.out.println("Continuing");
        }
        else{
            System.out.println("Invalid input");
        }
        return result;
    }
}
