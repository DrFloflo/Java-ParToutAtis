package tests;

import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import opinion.ISocialNetwork;
import opinion.Review;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>addFilm()</i> method.
 *
 * @author B. Prou, E. Cousin, GO
 * @version V2.0 - April 2018
 */

public class reviewItemReviewTest {

    /**
     * Add in the <i>SocialNetwork</i> a new review for a review.
     * If this member has already given a review for this
     * same review before, the new review is refused.
     *
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed film's title
     * @param mark
     *            the mark given by the member for this film
     * @param comment
     *            the comment given by the member for this film
     *
     * @throws BadEntryException
     *             <ul>
     *             <li>if login is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if password is not instantiated or contains less than
     *             four characters (not taking into account leading or trailing
     *             blanks)</li>
     *             <li>if title is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if mark is not greater or equals to 0.0 and lesser or
     *             equals to 5.0.</li>
     *             <li>if comment is not instantiated</li>
     *             </ul>
     * <br>
     * @throws NotMemberException
     *             if login does not match with the login of a registered member
     *             in <i>SocialNetwork</i> or if password does not correspond to
     *             his registered password.
     * @throws NotItemException
     *             if title is not registered as a film's title in the
     *             <i>SocialNetwork</i>
     *
     * @return mean of the marks for this film
     */
    private static int reviewItemReviewBadEntryTest(ISocialNetwork sn, String login, String password,
                                                  String title, Review laReview,float mark, String comment, String testId,
                                                  String errorMessage) {

       // int nbReviews = sn.nbReviews(); // Number of films when starting to
        // run this method
        try {
            sn.reviewItemReview(login, password, title, laReview, mark, comment); // Try to add this film
            // Reaching this point means that no exception was thrown by
            // addReviews()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) { // BadEntry exception was thrown by
            return 1;
        }catch (NotMemberException e) { // BadEntry exception was thrown by

        }catch (NotItemException e) { // BadEntry exception was thrown by
            return 1;
        } catch (Exception e) { // An exception was thrown by addReview(), but
            // it was not the expected exception BadEntry
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
        return 0;
    }

    /**
     * Add in the <i>SocialNetwork</i> a new review for a film on behalf of a
     * specific member.</br> If this member has already given a review for this
     * same film before, the new review replaces the previous one.
     *
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed film's title
     * @param mark
     *            the mark given by the member for this film
     * @param comment
     *            the comment given by the member for this film
     *
     * @throws BadEntryException
     *             <ul>
     *             <li>if login is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if password is not instantiated or contains less than
     *             four characters (not taking into account leading or trailing
     *             blanks)</li>
     *             <li>if title is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if mark is not greater or equals to 0.0 and lesser or
     *             equals to 5.0.</li>
     *             <li>if comment is not instantiated</li>
     *             </ul>
     * <br>
     * @throws NotMemberException
     *             if login does not match with the login of a registered member
     *             in <i>SocialNetwork</i> or if password does not correspond to
     *             his registered password.
     * @throws NotItemException
     *             if title is not registered as a film's title in the
     *             <i>SocialNetwork</i>
     *
     * @return mean of the marks for this film
     */
    private static int reviewItemReviewAlreadyExistsTest(ISocialNetwork sn, String login, String password,
                                                         String title, Review laReview,float mark, String comment, String testId,
                                                         String errorMessage) {
        int nbReview = sn.nbReview(); // Number of films when starting to
        // process this method
        try {
            sn.reviewItemReview(login, password, title, laReview,mark, comment); // Try to add this film
            // Reaching this point means that no exception was thrown by
            // addFilm()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) {// AlreadyExists exception was
            if (sn.nbReview() != nbReview) {
                System.out
                        .println("Err "+ testId+ " : FilmAlreadyExists was thrown, but the number of Films was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
            // display
        }  catch (NotItemException e) {// AlreadyExists exception was
            if (sn.nbReview() != nbReview) {
                System.out
                        .println("Err "+ testId+ " : FilmAlreadyExists was thrown, but the number of Films was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
            // display
        } catch (Exception e) { // An exception was thrown by addFilm(), but
            // it was not the expected exception
            // AlreadyExists
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }

    /**
     * Add in the <i>SocialNetwork</i> a new review for a film on behalf of a
     * specific member.</br> If this member has already given a review for this
     * same film before, the new review replaces the previous one.
     *
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed film's title
     * @param mark
     *            the mark given by the member for this film
     * @param comment
     *            the comment given by the member for this film
     *
     * @throws BadEntryException
     *             <ul>
     *             <li>if login is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if password is not instantiated or contains less than
     *             four characters (not taking into account leading or trailing
     *             blanks)</li>
     *             <li>if title is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if mark is not greater or equals to 0.0 and lesser or
     *             equals to 5.0.</li>
     *             <li>if comment is not instantiated</li>
     *             </ul>
     * <br>
     * @throws NotMemberException
     *             if login does not match with the login of a registered member
     *             in <i>SocialNetwork</i> or if password does not correspond to
     *             his registered password.
     * @throws NotItemException
     *             if title is not registered as a film's title in the
     *             <i>SocialNetwork</i>
     *
     * @return mean of the marks for this film
     */
    private static int reviewItemReviewOKTest(ISocialNetwork sn, String login, String password,
                                              String title, Review laReview,float mark, String comment, String testId,
                                              String errorMessage) {
       // int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.reviewItemReview(login, password, title, laReview, mark, comment); // Try to add this film
            System.out.println("Err " + testId + " : unexpected exception "); // Error
        } catch (NotItemException e) {
            return 1;
        }catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out.println("Err " + testId + " : unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
        return 0;
    }

    /**
     * Add in the <i>SocialNetwork</i> a new review for a film on behalf of a
     * specific member.</br> If this member has already given a review for this
     * same film before, the new review replaces the previous one.
     *
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed film's title
     * @param mark
     *            the mark given by the member for this film
     * @param comment
     *            the comment given by the member for this film
     *
     * @throws BadEntryException
     *             <ul>
     *             <li>if login is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if password is not instantiated or contains less than
     *             four characters (not taking into account leading or trailing
     *             blanks)</li>
     *             <li>if title is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if mark is not greater or equals to 0.0 and lesser or
     *             equals to 5.0.</li>
     *             <li>if comment is not instantiated</li>
     *             </ul>
     * <br>
     * @throws NotMemberException
     *             if login does not match with the login of a registered member
     *             in <i>SocialNetwork</i> or if password does not correspond to
     *             his registered password.
     * @throws NotItemException
     *             if title is not registered as a film's title in the
     *             <i>SocialNetwork</i>
     *
     * @return mean of the marks for this film
     */
    private static int reviewItemFilmOK(ISocialNetwork sn, String login, String password,
                                        String title, float mark, String comment, String testId) {
        // int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this film
            System.out.println("Err " + testId + " : unexpected exception "); // Error
        } catch (NotItemException e) {
            return 1;
        }catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out.println("Err " + testId + " : unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
        return 0;
    }

    /**
     * Check that this new film (login, password, title, kind, director, scenarist, duration) can be (and <i>is</i>)
     * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
     * : the new film was added.</br> If not OK, an error message is displayed
     * and 1 is returned ; the new film was not correctly added.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - Member's login
     * @param password
     *            - Member's password
     * @param title
     *            - Titre du film
     * @param kind
     *            - Genre du Film
     * @param director
     *            - Directeur du film
     * @param scenarist
     *            - Scénariste du film
     * @param duration
     *            - Durée du film
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemFilmOK(ISocialNetwork sn, String login, String password,
                                        String title, String kind, String director,
                                        String scenarist, int duration, String testId) {
        int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.addItemFilm(login, password, title, kind, director, scenarist, duration); // Try to add this film
            // No exception was thrown. That's a good start !
            if (sn.nbFilms() != nbFilms + 1) { // But the number of films
                // hasn't changed
                // accordingly
                System.out.println("Err " + testId + " : the number of films (" + nbFilms + ") was not incremented"); // Error message displayed
                return 1; // return error code
            } else
                return 0; // return success code : everything is OK, nothing to
            // display
        } catch (NotMemberException e) {// An exception was thrown by addFilm()
            //System.out.println("Err " + testId + " : unexpected exception " + e); // Error
            return 1; // return error code
        }
        catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out
                    .println("Err " + testId + " : unexpected exception " + e);
            return 1; // return error code
        }
    }

    /**
     * Check that this new member (login, pwd, profile) can be (and <i>is</i>)
     * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
     * : the new member was added.</br> If not OK, an error message is displayed
     * and 1 is returned ; the new member was not correctly added.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - new member's login
     * @param pwd
     *            - new member's password
     * @param profile
     *            - new member's profile
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int addMemberOK(ISocialNetwork sn, String login,
                                   String pwd, String profile, String testId) {
        int nbMembers = sn.nbMembers(); // Number of members when starting to
        // process this method
        try {
            sn.addMember(login, pwd, profile); // Try to add this member
            // No exception was thrown. That's a good start !
            if (sn.nbMembers() != nbMembers + 1) { // But the number of members
                // hasn't changed
                // accordingly
                System.out.println("Err " + testId
                        + " : the number of members (" + nbMembers
                        + ") was not incremented"); // Error message displayed
                return 1; // return error code
            } else
                return 0; // return success code : everything is OK, nothing to
            // display
        }
        catch (BadEntryException e){
            //System.out.println("Err " + testId + " : BadEntryException exception " + e); // Error
            return 1; // return error code
        }

        catch (Exception e) {// An exception was thrown by addMember() : this
            // is an error case
            System.out
                    .println("Err " + testId + " : unexpected exception " + e); // Error
            // message
            // displayed
            //e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
    }


    private static int reviewItemFilmOKTest(ISocialNetwork sn, String login, String password,
                                            String title, float mark, String comment, String testId) {
        // int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this film
            System.out.println("Err " + testId + " : unexpected exception "); // Error
        } catch (NotItemException e) {
            return 1;
        }catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out.println("Err " + testId + " : unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
        return 0;
    }

    private static int reviewItemFilmAlreadyExistsTest(ISocialNetwork sn, String login, String password,
                                                       String title, float mark, String comment, String testId,
                                                       String errorMessage) {
        int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this film
            // Reaching this point means that no exception was thrown by
            // addFilm()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) {// AlreadyExists exception was
            if (sn.nbFilms() != nbFilms) {
                System.out
                        .println("Err "+ testId+ " : FilmAlreadyExists was thrown, but the number of Films was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
            // display
        }  catch (NotItemException e) {// AlreadyExists exception was
            if (sn.nbFilms() != nbFilms) {
                System.out
                        .println("Err "+ testId+ " : FilmAlreadyExists was thrown, but the number of Films was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
            // display
        } catch (Exception e) { // An exception was thrown by addFilm(), but
            // it was not the expected exception
            // AlreadyExists
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }

    private static int addMemberBadEntryTest(ISocialNetwork sn, String login,
                                             String pwd, String profile, String testId, String errorMessage) {

        int nbMembers = sn.nbMembers(); // Number of members when starting to
        // run this method
        try {
            sn.addMember(login, pwd, profile); // Try to add this member
            // Reaching this point means that no exception was thrown by
            // addMember()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) { // BadEntry exception was thrown by
            // addMember() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            if (sn.nbMembers() != nbMembers) { // The number of members has
                // changed : this is an error
                // case.
                System.out
                        .println("Err "
                                + testId
                                + " : BadEntry was thrown but the number of members was changed"); // Display
                // a
                // specific
                // error
                // message
                return 1; // return "error" value
            } else
                // The number of members hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing
            // to display
        } catch (Exception e) { // An exception was thrown by addMember(), but
            // it was not the expected exception BadEntry
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }

    /**
     * <i>addFilm()</i> main test :
     * <ul>
     * <li>check if Films can be added</li>
     * <li>check if incorrect parameters cause addFilm() to throw BadEntry
     * exception</li>
     * <li>check if adding already registered Films cause addFilm() to throw
     * AlreadyExists exception</li>
     * </ul>
     *
     * @return a summary of the performed tests
     */
    public static TestReport test(){

        ISocialNetwork sn = new SocialNetwork();

        int nbReview = sn.nbReview(); // number of books in 'sn' (should be 0
        // here)
        Review review;
        int nbTests = 0; // total number of performed tests
        int nbErrors = 0; // total number of failed tests

        nbTests++;
        nbErrors += addMemberOK(sn, "Paul", "paul", "", "1.1 Add member");
        nbTests++;
        nbErrors += addMemberOK(sn, "Marc", "marc", "", "1.2 Add Member");

        nbTests++;
        nbErrors += addNewItemFilmOK(sn, "Paul", "paul", "The big Lebowski", "Comédie", "Ethan Coen, Joel Coen", "Ethan Coen, Joel Coen",
                120,"2.1 Add a film");

        nbTests++;
        nbErrors += reviewItemFilmOK(sn, "Paul", "paul", "The big Lebowski", 7.5f, "Film d'une grande qualitée", "3.1 Add review film");


        Review reviewTrouve = null;
        try {
            opinion.Film leFilm = sn.getFilm("The big Lebowski");
            System.out.println("ok");
            for (Review eachReviewInFilm : leFilm.getReview()) {            //find review in The big Lebowski written by paul
                if (eachReviewInFilm .getMember().equals("paul")) {
                    reviewTrouve=eachReviewInFilm ;
                }
            }
        }
        catch (BadEntryException e) {// AlreadyExists exception was
            return null;
        }
        catch (Exception e){ //This shouldn't happen
            System.out.println("BadEntryException error: "+e);
            return null;
        }

        System.out.println("Testing reviewItemReview()");

        // <=> test n°1

        // check if incorrect parameters cause reviewItemReview() to throw BadEntry
        // exception

        nbTests++;
        nbErrors += reviewItemReviewBadEntryTest(sn, null, "marc",
                "The big Lebowski", reviewTrouve,2.5f, "aaaa", "1.1","addFilm need the reject null login");

        // <=> test n°2

        // populate 'sn' with 3 films

        nbTests++;
        nbErrors += reviewItemFilmOKTest(sn, "Paul", "aaaa",
                "Bof", 2.5f, "Nul", "2.1a");
        nbTests++;
        nbErrors += reviewItemFilmOKTest(sn, "Taylor", "aaaa",
                "Pas mal", 5f, "Jean crois pas mes yeux", "2.2a");
        nbTests++;
        nbErrors += reviewItemFilmOKTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, "Incroyable", "2.3a");

        // try to add already registered films
        nbTests++;
        nbErrors += reviewItemFilmAlreadyExistsTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, "Incroyable", "2.1","The member has already post a review for this book");
        nbTests++;
        nbErrors += reviewItemFilmAlreadyExistsTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, "InCroYable", "2.2","The member has already post a review for this book with different upper case");
        nbTests++;
        nbErrors += reviewItemFilmAlreadyExistsTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, " Incroyable ", "2.3","The member has already post a review for this book with less space");
        // check that 'sn' was not modified
        /*if (nbMembers != sn.nbMembers()) {
            System.out
                    .println("Error : the number of members was unexepectedly changed by addFilm()");
            nbErrors++;
        }
        nbTests++;
        if (nbBooks != sn.nbBooks()) {
            System.out
                    .println("Error : the number of books was unexepectedly changed by addFilm()");
            nbErrors++;
        }*/

        // Display final state of 'sn'
        System.out.println("Final state of the social network : " + sn);

        // Print a summary of the tests and return test results
        try{
            TestReport tr = new TestReport(nbTests, nbErrors);
            System.out.println("AddFilmTest : " + tr);
            return tr;
        }
        catch (NotTestReportException e){ //This shouldn't happen
            System.out.println("Unexpected error in AddFilmTest test code - Can't return valuable test results");
            return null;
        }
    }



    /**
     * Launches test()
     * @param args not used
     */
    public static void main(String[] args) {
        test();
    }
}
