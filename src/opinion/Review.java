package opinion;

public class Review {

    private String title;
    private int date;
    public String member;
    private float note;
    private String comment;
    private int id;
    public static int lastID;

    public Review(String title, int date, String member, float note, String comment) {
        lastID++;
        this.title = title;
        this.date = date;
        this.member = member;
        this.note = note;
        this.comment = comment;
        this.id = lastID;
    }
}
