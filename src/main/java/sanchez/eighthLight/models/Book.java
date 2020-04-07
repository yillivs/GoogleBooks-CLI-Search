package sanchez.eighthLight.models;

/**
 * Book Class
 */
public class Book {

    private String[] author;
    private String title;
    private String publisher;

    public Book(){}

    public Book(String[] a, String t, String p){
        this.author = a;
        this.title = t;
        this.publisher = p;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }
}
