package opinion;

import java.util.LinkedList;

public class Review {

    private String title;
    private int date;
    public String member;
    private float note;     //de 0 a 10
    private String comment;
    private int id;
    public static int lastID;
    LinkedList<Review> listeReview = new LinkedList<Review>();

    public Review(String title, int date, String member, float note, String comment) {
        lastID++;
        this.title = title;
        this.date = date;
        this.member = member;
        this.note = note;
        this.comment = comment;
        this.id = lastID;
    }
    public String getTitle() {
        return this.title;
    }
    public int getDate() {
        return this.date;
    }
    public String getMember() { return this.member; }
    public float getNote() { return this.note; }
    public String getComment() { return this.comment; }

}
