package sanchez.eighthLight.controllers;


import sanchez.eighthLight.models.Book;

import java.util.ArrayList;

public class ReadingListController {

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
