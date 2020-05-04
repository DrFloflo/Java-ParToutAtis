package opinion;

import java.util.LinkedList;

public class Book {
    private String kind;
    private String title;
    private String author;
    private int nbPages;
    LinkedList<Review> listeReview = new LinkedList<Review>();

    public Book(String kind, String title, String author, int nbPages){
        this.kind=kind;
        this.title=title;
        this.author=author;
        this.nbPages=nbPages;
    }
}