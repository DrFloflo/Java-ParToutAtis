package opinion;

import java.util.LinkedList;

public class Review {
    /**
     *
     * @param date
     *            - the creation's date of the review
     * @param title
     *            - title of the review
     * @param member
     *            - author of the review
     * @param note
     *            - the mark of the review
     * @param listeReview
     *            - the review's list of reviews
     * @param comment
     *            - review's comment
     * @param id
     *            - the id of the review
     * @param lastid
     *            - the list id use by a review, incremented each time
     */
    private String title;
    private int date;
    public String member;
    private float note;     //de 0 a 10
    private String comment;
    private int id;
    public static int lastID;
    LinkedList<Review> listeReview = new LinkedList<Review>();

    /**
     *
     * This class increment the id of the review. The id is unique for each review.
     */

    public Review(String title, int date, String member, float note, String comment) {
        lastID++;
        this.title = title;
        this.date = date;
        this.member = member;
        this.note = note;
        this.comment = comment;
        this.id = lastID;
    }
    /**
     *
     * @return the title of the review
     */
    public String getTitle()
    {
        return this.title;
    }
    /**
     *
     * @return the creation's date of the review
     */
    public int getDate()
    {
        return this.date;
    }
    /**
     *
     * @return the author of the review
     */
    public String getMember()
    {
        return this.member;
    }
    /**
     *
     * @return the mark of the review
     */
    public float getNote()
    {
        return this.note;
    }
    /**
     *
     * @return the comment of the review
     */
    public String getComment()
    {
        return this.comment;
    }

}
