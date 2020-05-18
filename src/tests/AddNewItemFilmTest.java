package tests;

import exceptions.ItemFilmAlreadyExistsException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;


import exceptions.BadEntryException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.NotTestReportException;

/**
 * Tests for the SocialNetwork.<i>addFilm()</i> method.
 *
 * @author B. Prou, E. Cousin, GO
 * @version V2.0 - April 2018
 */

public class AddNewItemFilmTest {

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
    private static int addNewItemFilmBadEntryTest(ISocialNetwork sn, String login, String password,
                                                  String title, String kind, String director,
                                                  String scenarist, int duration, String testId,
                                                  String errorMessage) {

        int nbFilms = sn.nbFilms(); // Number of films when starting to
        // run this method
        try {
            sn.addItemFilm(login, password, title, kind, director, scenarist, duration); // Try to add this film
            // Reaching this point means that no exception was thrown by
            // addFilm()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) { // BadEntry exception was thrown by
            // addFilm() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            if (sn.nbFilms() != nbFilms) { // The number of films has
                // changed : this is an error
                // case.
                System.out
                        .println("Err "
                                + testId
                                + " : BadEntry was thrown but the number of films was changed"); // Display
                // a
                // specific
                // error
                // message
                return 1; // return "error" value
            } else
                // The number of films hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing
            // to display
        } catch (Exception e) { // An exception was thrown by addfilm(), but
            // it was not the expected exception BadEntry
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
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
    private static int addNewItemFilmAlreadyExistsTest(ISocialNetwork sn,
                                                       String login, String password, String title,
                                                       String kind, String director, String scenarist,
                                                       int duration, String testId, String errorMessage) {
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
    private static int addMemberOKTest(ISocialNetwork sn, String login,
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
        } catch (Exception e) {// An exception was thrown by addMember() : this
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
        nbErrors += addMemberOKTest(sn, "Paul", "paul", "Nouveau", "1.1a");
        nbMembers++;
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, null, "paul",
                "aaaa", "aaa", "aaaa", "aaaaa",
                100000000, "1.1","addFilm doit rejeter les logins null");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Paul", null,
                "aaaa", "aaa", "aaaa", "aaaaa",
                100000000, "1.2","addFilm doit rejeter les passwords null");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Paul", "paul",
                null, "aaa", "aaaa", "aaaaa",
                100000000, "1.3","addFilm doit rejeter les variables title null");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Paul", "paul",
                "aaaa", null, "aaaa", "aaaaa",
                100000000, "1.4","addFilm doit rejeter les variable kind null");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Paul", "paul",
                "aaaa", "aaa", null, "aaaaa",
                100000000, "1.5","addFilm doit rejeter les variables directors null");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Paul", "paul",
                "aaaa", "aaa", "aaaa", null,
                100000000, "1.6","addFilm doit rejeter les variables scenarist null");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Paul", "paul",
                "aaaa", "aaa", "aaaa", "aaaaa",
                -1000, "1.7","addFilm doit rejeter les variables durations négatives");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Jean", "paul",
                "aaaa", "aaa", "aaaa", "aaa",
                120,"1.8" ,"addBook doit rejeter les utilisateurs inconnus");
        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(sn, "Jean", "mauvais mdr",
                "aaaa", "aaa", "aaaa", "aaa",
                120,"1.9","addBook doit rejeter les mauvais mdp");
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
