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
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getKind() {
        return this.kind;
    }
    public int getPages() {
        return this.nbPages;
    }
    public LinkedList<Review> getReview() {
        return this.listeReview;
    }
}