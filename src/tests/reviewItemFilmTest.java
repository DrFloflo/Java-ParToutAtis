package tests;

import exceptions.*;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;


import exceptions.ItemFilmAlreadyExistsException;

/**
 * Tests for the SocialNetwork.<i>addFilm()</i> method.
 *
 * @author B. Prou, E. Cousin, GO
 * @version V2.0 - April 2018
 */

public class reviewItemFilmTest {

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
    private static int reviewItemFilmBadEntryTest(ISocialNetwork sn, String login, String password,
                                                  String title, Float mark, String comment, String testId,
                                                  String errorMessage) {

       // int nbReviews = sn.nbReviews(); // Number of films when starting to
        // run this method
        try {
            sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this film
            // Reaching this point means that no exception was thrown by
            // addReviews()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) { // BadEntry exception was thrown by
            // addFilm() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            /*if (sn.nbFilms() != nbFilms) { // The number of films has
                System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of films was changed"); // Display
                return 1; // return "error" value
            } else
                // The number of reviews hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing*/
            // to display
        } catch (Exception e) { // An exception was thrown by addReview(), but
            // it was not the expected exception BadEntry
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
    private static int addNewItemFilmAlreadyExistsTest(ISocialNetwork sn, String login, String password,
                                                       String title, Float mark, String comment, String testId,
                                                       String errorMessage) {
        int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.addItemFilm(login, password, title, kind, director, scenarist, duration); // Try to add this film
            // Reaching this point means that no exception was thrown by
            // addFilm()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (ItemFilmAlreadyExistsException e) {// AlreadyExists exception was
            // thrown by addFilm() :
            // this is a good start!
            // Let's now check if 'sn'
            // was not impacted
            if (sn.nbFilms() != nbFilms) {
                System.out
                        .println("Err "
                                + testId
                                + " : FilmAlreadyExists was thrown, but the number of Films was changed"); // Display
                // a
                // specific
                // error
                // message
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
    private static int addNewItemFilmOKTest(ISocialNetwork sn, String login, String password,
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
        } catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out
                    .println("Err " + testId + " : unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
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

        int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
        // here)
        int nbMembers = sn.nbMembers(); // number of members in 'sn' (should be 0
        // here)

        int nbTests = 0; // total number of performed tests
        int nbErrors = 0; // total number of failed tests

        System.out.println("Testing addFilm()");

        // <=> test n°1

        // check if incorrect parameters cause addFilm() to throw BadEntry
        // exception

        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, null, "aaaa",
                "aaaa", "aaa", "aaaa", "aaaaa",
                100000000, "1.1","addFilm doit rejeter les logins null");
        nbErrors += addNewItemFilmBadEntryTest(sn, "aaaa", null,
                "aaaa", "aaa", "aaaa", "aaaaa",
                100000000, "1.2","addFilm doit rejeter les passwords null");
        nbErrors += addNewItemFilmBadEntryTest(sn, "aaaa", "aaaa",
                null, "aaa", "aaaa", "aaaaa",
                100000000, "1.3","addFilm doit rejeter les variables title null");
        nbErrors += addNewItemFilmBadEntryTest(sn, "aaaa", "aaaa",
                "aaaa", null, "aaaa", "aaaaa",
                100000000, "1.4","addFilm doit rejeter les variable kind null");
        nbErrors += addNewItemFilmBadEntryTest(sn, "aaaa", "aaaa",
                "aaaa", "aaa", null, "aaaaa",
                100000000, "1.5","addFilm doit rejeter les variables directors null");
        nbErrors += addNewItemFilmBadEntryTest(sn, "aaaa", "aaaa",
                "aaaa", "aaa", "aaaa", null,
                100000000, "1.6","addFilm doit rejeter les variables scenarist null");
        nbErrors += addNewItemFilmBadEntryTest(sn, "aaaa", "aaaa",
                "aaaa", "aaa", "aaaa", "aaaaa",
                -1000, "1.7","addFilm doit rejeter les variables durations négatives");

        // <=> test n°2

        // populate 'sn' with 3 films

        nbTests++;
        nbErrors += addNewItemFilmOKTest(sn, "Paul", "paul", "The big Lebowski",
                " Comédie", "Ethan Coen, Joel Coen", "Ethan Coen, Joel Coen",
                120,"2.1a");
        nbTests++;
        nbErrors += addNewItemFilmOKTest(sn, "Paul", "paul", "Gran Torino",
                " Drame/Thriller", "Clint Eastwood", " Nick Schenk",
                119,"2.2a");
        nbTests++;
        nbErrors += addNewItemFilmOKTest(sn, "Paul", "paul", "Gatsby le magnifique",
                " Amour/Drame", "Baz Luhrmann", "Baz Luhrmann,Craig Pearce",
                118,"2.3a");

        // try to add already registered films
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(sn, "Paul", "paul", "The big Lebowski",
                " Comédie", "Ethan Coen, Joel Coen", "Ethan Coen, Joel Coen",
                120,"2.1", "Le film est déjà enregistré");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(sn, "Paul", "paul", "Gran Torino",
                " Drame/Thriller", "Clint Eastwood", " Nick Schenk",
                122,"2.2", "Le film est déjà enregistré");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(sn, "Paul", "paul", "GaTsBy le MAGnifique",
                " Amour/Drame", "Baz Luhrmann", "Baz Luhrmann,Craig Pearce",
                118,"2.3", "Le film est déjà enregistré avec des majuscules différentes");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(sn, "Paul", "paul", " Gatsby le magnifique ",
                " Amour/Drame", "Baz Luhrmann", "Baz Luhrmann,Craig Pearce",
                118,"2.4", "Le film est déjà enregistré mais sans espaces autour");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(sn, "Paul", "paul", "Gatsby"+"le"+"magnifique",
                " Amour/Drame", "Baz Luhrmann", "Baz Luhrmann,Craig Pearce",
                118,"2.5", "A String concatenation building an already registered film was accepted as film for a new item");
        // check that 'sn' was not modified
        if (nbMembers != sn.nbMembers()) {
            System.out
                    .println("Error : the number of members was unexepectedly changed by addFilm()");
            nbErrors++;
        }
        nbTests++;
        if (nbBooks != sn.nbBooks()) {
            System.out
                    .println("Error : the number of books was unexepectedly changed by addFilm()");
            nbErrors++;
        }

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
