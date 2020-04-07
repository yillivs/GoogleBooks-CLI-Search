package sanchez.eighthLight.controllers;


import sanchez.eighthLight.models.Book;
import sanchez.eighthLight.models.Volume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CLIController {



    private static void printBook(Book book){
        System.out.printf("Title: '%s'\n", book.getTitle());

        System.out.print("Author(s): ");
        for(String author: book.getAuthor()){
            System.out.print(author + " ");
        }
        System.out.printf("\nPublisher: '%s'\n-----------\n", book.getPublisher());

    }

    public static void cliBooksQuery(BufferedReader reader, BookController bookController){
        String input;
        try {
            input = reader.readLine();

            if(input.equalsIgnoreCase("s")){
            System.out.println("Enter a query");
            input = reader.readLine();
            Volume volume = bookController.getBookList(input);
            ArrayList<Book> books = new ArrayList<>();
                for (Volume.Items b: volume.getItems()) {
                    books.add(new Book(b.getVolumeInfo().getAuthors(),b.getVolumeInfo().getTitle(), b.getVolumeInfo().getPublisher()));
                }

                for(Book b: books){
                    printBook(b);
                }

            }
        System.out.println("Enter one of the following commands.\n's': Search\n'q': Quit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run(){
        BookController bookController = new BookController();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter one of the following commands.\n's': Search\n'q': Quit");
            String input = "";

            do {
                cliBooksQuery(reader, bookController);
            } while (!input.equalsIgnoreCase("q"));

            reader.close();
        }
        catch (IOException e){
            System.err.println("I/O exception");
            e.printStackTrace();
        }
    }
}
