package opinion;

import java.util.LinkedList;

public class Book {
    /**
     *
     * @param kind
     *            - kind of the book
     * @param title
     *            - title of the book
     * @param author
     *            - author of the book
     * @param nbPages
     *            - The book's number of pages
     * @param listeReview
     *            - The book's list of reviews
     */

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
    /**
     *
     * @return the title of the book
     */
    public String getTitle() {
        return this.title;
    }
    /**
     *
     * @return the author of the book
     */
    public String getAuthor()
    {
        return this.author;
    }
    /**
     *
     * @return the kind of the book
     */
    public String getKind()
    {
        return this.kind;
    }
    /**
     *
     * @return the pages number of the book
     */
    public int getPages()
    {
        return this.nbPages;
    }
    /**
     *
     * @return the book's reviews
     */
    public LinkedList<Review> getReview()
    {
        return this.listeReview;
    }
}