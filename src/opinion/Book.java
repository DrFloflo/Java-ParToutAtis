package opinion;

public class Book {
    private String kind;
    private String title;
    private String author;
    private int nbPages;
    public String listeReview[];

    public Book(String kind, String title, String author, int nbPages){
        this.kind=kind;
        this.title=title;
        this.author=author;
        this.nbPages=nbPages;
    }
}