package sanchez.eighthLight.controllers;


import sanchez.eighthLight.models.Book;
import sanchez.eighthLight.models.Volume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CLIController {


    /**
     * Print and format Book
     * @param book book to be printed
     */
    private static void printBook(Book book){
        System.out.printf("Title: '%s'\n", book.getTitle());

        if(book.getAuthor() != null) {
            System.out.print("Author(s): ");
            for (String author : book.getAuthor()) {
                System.out.print(author + " ");
            }
        }
        System.out.printf("\nPublisher: '%s'\n-----------\n", book.getPublisher());

    }

    /**
     * Print and format reading list
     * @param readingList list of books to be printed
     */
    private static void printReadingList(ArrayList<Book> readingList){
        System.out.println("Reading List:");
        for(Book book: readingList){
            printBook(book);
        }
    }

    /**
     * Method handles retrieval of list of books and selection to add to reading list
     * @param readingList list of books that correspond to reading list
     * @param reader reader for user input
     * @param bookController book controller for call
     * @param readingListController controller for reading list manipulation
     * @return status 0 if user wants to quit; 1 to continue.
     */
    public static int cliBooksQuery(ArrayList<Book> readingList,BufferedReader reader, BookController bookController, ReadingListController readingListController){
        String input;
        int status = 1;
        ArrayList<Book> books = new ArrayList<>();
        try {
            input = reader.readLine();

            if(input.equalsIgnoreCase("s")){
            System.out.println("Enter a query");
            input = reader.readLine();
            Volume volume = bookController.getBookList(input);

                if(Integer.parseInt(volume.getTotalItems()) > 0) {
                    for (Volume.Items b : volume.getItems()) {
                        books.add(new Book(b.getVolumeInfo().getAuthors(), b.getVolumeInfo().getTitle(), b.getVolumeInfo().getPublisher()));
                    }
                    int index = 0;
                    for (Book b : books) {
                        System.out.printf("Book No. %d\n", index++);
                        printBook(b);
                    }
                    System.out.println("Enter Book No. [0-4] to add Book to reading list; 0 to cancel.");
                    input = reader.readLine();

                    readingList.add(readingListController.getReadingListSelection(books, Integer.parseInt(input)));
                }
                else{
                    System.out.println("No results");
                }
            }
            else if(input.equalsIgnoreCase("r")){
                printReadingList(readingList);
            }
            else if(input.equalsIgnoreCase("q")){
                status = 0;
            }
            else{
                System.out.println("Invalid command.");
            }
        } catch (Exception e){
            System.err.println("Please enter a numeric value for reading list selection");
        }
        if(status != 0)
            System.out.println("Enter one of the following commands.\n's': Search\n'r': View reading list\n'q': Quit");
        return status;
    }

    /**
     * Runs application
     */
    public static void run(){
        BookController bookController = new BookController();
        ReadingListController readingListController = new ReadingListController();
        ArrayList<Book> readingList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter one of the following commands.\n's': Search\n'q': Quit");
            int flag = 1;

            do {
                flag = cliBooksQuery(readingList ,reader, bookController, readingListController);
            } while (flag != 0);

            reader.close();
        }
        catch (IOException e){
            System.err.println("I/O exception");
        }
    }
}
