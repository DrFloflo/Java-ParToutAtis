package opinion;

public class Review {

    private String title;
    private int date;
    public String member;
    private int note;
    private String comment;

    public Review(String title, int date, String member, int note, String comment) {
        this.title = title;
        this.date = date;
        this.member = member;
        this.note = note;
        this.comment = comment;
    }
}
