package opinion;

import java.util.LinkedList;

public class Member {
    /**
     *
     * @param login
     *            - the member's login
     * @param pwd
     *            - the member's password
     * @param name
     *            - the member's name
     * @param date
     *            - the member's date of birth
     * @param mail
     *            - the member's mail
     * @param listeReview
     *            - the member's reviews
     * @param mykarma
     *            - the actual karma of the member
     * @param nbReview
     *            - the number of reviews posted by the member
     * @param total
     *            - temporal variable use for calculate the karma
     * */
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
    /**
     * Member's karma is the mean of all reviews of each opinion of the member.
     *
     * @return the karam of the member
     */
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
    /**
     *
     * @return the login of the member
     */
    public String getLogin()
    {
        return this.login;
    }
    /**
     *
     * @return the name of the member
     */
    public String getName()
    {
        return this.name;
    }
    /**
     *
     * @return the member's date of birth
     */
    public String getDate()
    {
        return this.date;
    }
    /**
     *
     * @return the password of the member
     */
    public String getPwd()
    {
        return this.pwd;
    }
    /**
     *
     * @return the mail of the member
     */
    public String getMail()
    {
        return this.mail;
    }
}
