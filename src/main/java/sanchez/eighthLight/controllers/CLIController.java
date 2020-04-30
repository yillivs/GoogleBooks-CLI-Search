package sanchez.eighthLight.controllers;

import sanchez.eighthLight.models.Book;
import sanchez.eighthLight.models.Volume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CLIController {

    private static ReadingListController readingList;
    private static BookController bookController;

    public CLIController(){
        readingList = new ReadingListController();
        bookController = new BookController();
    }

    public static BookController getBookController() {
        return bookController;
    }

    public static ReadingListController getReadingList() {
        return readingList;
    }

    /**
     * Print and format Book
     * @param book book to be printed
     */
    private static void printBook(Book book){
        System.out.printf("Title: '%s'", book.getTitle());

        if(book.getAuthor() != null) {
            System.out.print("\nAuthor(s): ");
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
     * Creates a list of books from a volume
     * @param volume object representing a group of books
     * @return arraylist of books
     */
    public static ArrayList<Book> getBooksFromVolume(Volume volume){
        ArrayList<Book> result = new ArrayList<>();
        for (Volume.Items b : volume.getItems()) {
            result.add(new Book(b.getVolumeInfo().getAuthors(), b.getVolumeInfo().getTitle(), b.getVolumeInfo().getPublisher()));
        }

        return result;
    }

    /**
     * Method handles retrieval of list of books and selection to add to reading list
     * @param readingList list of books that correspond to reading list
     * @param reader reader for user input
     * @return status 0 if user wants to quit; 1 to continue.
     */
    public static int cliBooksQuery(ArrayList<Book> readingList, BufferedReader reader){
        String input;
        int status = 1;
        ArrayList<Book> books;
        try {
            input = reader.readLine();
            switch(input.toLowerCase()) {
                case "s":
                    System.out.println("Enter a query");
                    input = reader.readLine();
                    Volume volume = getBookController().getBookList(input);

                    if (Integer.parseInt(volume.getTotalItems()) > 0) {
                        books = getBooksFromVolume(volume);
                        int index = 0;
                        for (Book b : books) {
                            System.out.printf("Book No. %d\n", index++);
                            printBook(b);
                        }
                        System.out.println("Enter Book No. [0-4] to add Book to reading list; 0 to cancel.");
                        input = reader.readLine();

                        readingList.add(getReadingList().getReadingListSelection(books, Integer.parseInt(input)));
                    } else {
                        System.out.println("No results");
                    }
                    break;
                case "r":
                    printReadingList(readingList);
                    break;
                case "q":
                    status = 0;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        } catch (Exception e){
            System.err.println("Please enter a numeric value for reading list selection " + e.getMessage());
        }
        if(status != 0)
            System.out.println("Enter one of the following commands.\n's': Search\n'r': View reading list\n'q': Quit");
        return status;
    }

    /**
     * Runs application
     */
    public static void run(){
        ArrayList<Book> readingList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter one of the following commands.\n's': Search\n'q': Quit");
            int flag = 1;

            do {
                flag = cliBooksQuery(readingList ,reader);
            } while (flag != 0);

            reader.close();
        }
        catch (IOException e){
            System.err.println("I/O exception");
        }
    }
}
