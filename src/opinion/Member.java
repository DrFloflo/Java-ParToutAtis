package opinion;

import java.util.LinkedList;

public class Member {

    private String name;
    private String date;
    private String login;
    private String pwd;
    private String mail;
    LinkedList<Review> listeReview = new LinkedList<Review>();

    public Member(String name, String date, String login, String pwd, String mail) {
        this.name = name;
        this.date = date;
        this.login = login;
        this.pwd = pwd;
        this.mail = mail;
    }

    public int getKarma() {
        int mykarma = 0;
        float total = 0f;
        int nbReview = 0;
        for (Review eachReview : this.listeReview) { //For each review the member wrote
            for (Review eachReviewReview : eachReview.listeReview) { //For each review this review
                nbReview++;
                total = total + eachReviewReview.getNote();
            }
        }
        mykarma = (int) (total/nbReview);
        return mykarma;
    }

    public String getLogin() {
        return this.login;
    }
    public String getName() {
        return this.name;
    }
    public String getDate() {
        return this.date;
    }
    public String getPwd() {
        return this.pwd;
    }
    public String getMail() {
        return this.mail;
    }
}
