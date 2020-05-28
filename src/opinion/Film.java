package opinion;

import java.util.LinkedList;

public class Film {
    /**
     *
     * @param kind
     *            - kind of the film
     * @param title
     *            - title of the film
     * @param scenarist
     *            - scenarist of the film
     * @param duration
     *            - The film's number of minutes
     * @param director
     *            - The director of the film
     * @param listeReview
     *            - The film's list of reviews
     */
    private String director;
    private String kind;
    private String title;
    private String scenarist;
    private int duration;
    LinkedList<Review> listeReview = new LinkedList<Review>();

    public Film(String director, String kind, String title, String scenarist, int duration){
        this.director=director;
        this.kind=kind;
        this.title=title;
        this.scenarist=scenarist;
        this.duration=duration;
    }
    /**
     *
     * @return the title of the film
     */
    public String getTitle() {
        return this.title;
    }
    /**
     *
     * @return the director of the film
     */
    public String getDirector()
    {
        return this.director;
    }
    /**
     *
     * @return the scenarist of the film
     */
    public String getScenarist()
    {
        return this.scenarist;
    }
    /**
     *
     * @return the kind of the film
     */
    public String getKind()
    {
        return this.kind;
    }
    /**
     *
     * @return the duration (in minutes) of the film
     */
    public int getDuration()
    {
        return this.duration;
    }
    /**
     *
     * @return the film's reviews
     */
    public LinkedList<Review> getReview()
    {
        return this.listeReview;
    }
}
